package com.example.zpo.services;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.dtos.HourSlotDTO;
import com.example.zpo.dtos.ScheduleDTO;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.mappers.ClassDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ClassDTOMapper classDTOMapper;
    private final ClassService classService;

    @Autowired
    public ScheduleService(ClassDTOMapper classDTOMapper, ClassService classService){
        this.classDTOMapper = classDTOMapper;
        this.classService = classService;
    }

    public List<HourSlotDTO> createSchedule(List<UniversityClass> classes) {
        List<HourSlotDTO> hourSlots = createEmptyHourSlots();

        for (UniversityClass universityClass : classes) {
            LocalTime startTime = universityClass.getStart_time(); // Assuming LocalTime type
            Long duration = universityClass.getDuration(); // Duration in minutes

            assignClassToSlots(hourSlots, startTime, duration, universityClass);
        }

        return hourSlots;
    }

    private void assignClassToSlots(List<HourSlotDTO> hourSlots, LocalTime startTime, Long duration, UniversityClass universityClass) {
        LocalTime currentTime = startTime;
        Long remainingDuration = duration;

        while (remainingDuration > 0) {
            int currentHour = currentTime.getHour();

            // Find the corresponding hour slot
            HourSlotDTO hourSlot = hourSlots.stream()
                    .filter(slot -> slot.hour().equals(String.format("%02d:00", currentHour)))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Hour slot not found"));

            // Calculate time for this slot (either remaining duration or full hour)
            Long minutesInCurrentSlot = Math.min(remainingDuration, 60 - currentTime.getMinute());

            // Create partial class DTO for this slot
            ClassDTO partialClass = classDTOMapper.apply(universityClass);
            // Add class to the slot
            hourSlot.classes().add(partialClass);

            // Update time and duration
            remainingDuration -= minutesInCurrentSlot;
            currentTime = currentTime.plusMinutes(minutesInCurrentSlot);
        }
    }

    private List<HourSlotDTO> createEmptyHourSlots() {
        List<HourSlotDTO> hourSlots = new ArrayList<>();

        for (int hour = 8; hour <= 20; hour++) {
            hourSlots.add(new HourSlotDTO(String.format("%02d:00", hour), new ArrayList<>()));
        }

        return hourSlots;
    }

    public ScheduleDTO getScheduleForGroup(Long groupID) {
        List<HourSlotDTO> hourSlotDTOS = createSchedule(classService.getByGroupID(groupID));
        return new ScheduleDTO(hourSlotDTOS);
    }

    public ScheduleDTO getScheduleForProfessor(Long professorID) {
        List<HourSlotDTO> hourSlotDTOS = createSchedule(classService.getByProfessorID(professorID));
        return new ScheduleDTO(hourSlotDTOS);
    }
}
