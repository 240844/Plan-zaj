package com.example.zpo.services;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.dtos.HourSlotDTO;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.mappers.ClassDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HourSlotService {
    private final String[] DAYS = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };
    private final ClassDTOMapper classDTOMapper;
    private final ClassService classService;

    @Autowired
    public HourSlotService(ClassDTOMapper classDTOMapper, ClassService classService){
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
            hourSlot.classes().put(universityClass.getDay_of_week(), partialClass);

            // Update time and duration
            remainingDuration -= minutesInCurrentSlot;
            currentTime = currentTime.plusMinutes(minutesInCurrentSlot);
        }
    }

    private List<HourSlotDTO> createEmptyHourSlots() {
        List<HourSlotDTO> hourSlots = new ArrayList<>();

        for (int hour = 8; hour <= 20; hour++) {
            hourSlots.add(new HourSlotDTO(String.format("%02d:00", hour), new HashMap<>()));
        }


        for(HourSlotDTO hourSlot : hourSlots){
            for(String day : DAYS) {
                hourSlot.classes().put(day, null);
            }
        }

        return hourSlots;
    }
}
