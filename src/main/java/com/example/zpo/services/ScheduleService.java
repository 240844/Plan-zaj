package com.example.zpo.services;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.dtos.HourSlotDTO;
import com.example.zpo.dtos.ScheduleDTO;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.mappers.ClassDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final HourSlotService hourSlotService;
    private final ClassService classService;

    @Autowired
    public ScheduleService(HourSlotService hourSlotService, ClassService classService){
        this.hourSlotService = hourSlotService;
        this.classService = classService;
    }

    public ScheduleDTO getScheduleForGroup(Long groupID) {
        List<HourSlotDTO> hourSlotDTOS = this.hourSlotService.createSchedule(classService.getByGroupID(groupID));
        return new ScheduleDTO(hourSlotDTOS);
    }

    public ScheduleDTO getScheduleForProfessor(Long professorID) {
        List<HourSlotDTO> hourSlotDTOS = this.hourSlotService.createSchedule(classService.getByProfessorID(professorID));
        return new ScheduleDTO(hourSlotDTOS);
    }
}
