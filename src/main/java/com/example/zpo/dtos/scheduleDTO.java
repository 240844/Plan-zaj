package com.example.zpo.dtos;

import java.util.List;

public record scheduleDTO(
        List<DayScheduleDTO> weeklySchedule
) {
}
