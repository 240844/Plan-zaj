package com.example.zpo.dtos;

import java.util.List;

public record ScheduleDTO(
        List<HourSlotDTO> weeklySchedule
) {
}
