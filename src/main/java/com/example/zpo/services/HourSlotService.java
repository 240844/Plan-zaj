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

    public List<HourSlotDTO> createSchedule(List<UniversityClass> classes, boolean isProfessor) {
        List<HourSlotDTO> hourSlots = createEmptyHourSlots();

        for (UniversityClass universityClass : classes) {
            LocalTime startTime = universityClass.getStart_time();
            Long duration = universityClass.getDuration();

            assignClassToSlots(hourSlots, startTime, duration, universityClass);

            if (universityClass.getLectureID() == null) {
                continue;
            }

            if (!isProfessor) {
                UniversityClass lecture = classService.getByID(universityClass.getLectureID()).orElse(null);
                if (lecture == null) {
                    continue;
                }

                LocalTime lectureStartTime = lecture.getStart_time();
                Long lectureDuration = lecture.getDuration();

                assignClassToSlots(hourSlots, lectureStartTime, lectureDuration, lecture);
            }
        }

        return hourSlots;
    }

    private void assignClassToSlots(List<HourSlotDTO> hourSlots, LocalTime startTime, Long duration, UniversityClass universityClass) {
        LocalTime currentTime = startTime;
        Long remainingDuration = duration;

        while (remainingDuration > 0) {
            int currentHour = currentTime.getHour();

            HourSlotDTO hourSlot = hourSlots.stream()
                    .filter(slot -> slot.hour().equals(String.format("%02d:00", currentHour)))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Hour slot not found"));


            ClassDTO partialClass = classDTOMapper.apply(universityClass);
            hourSlot.classes().put(universityClass.getDay_of_week(), partialClass);
            remainingDuration -= 45;

            currentTime = currentTime.plusMinutes(60);

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
