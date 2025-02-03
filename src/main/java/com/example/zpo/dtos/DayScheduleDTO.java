package com.example.zpo.dtos;

import java.util.List;

public record DayScheduleDTO(
        String day,
        List<HourSlotDTO> hourSlots
) {
}
