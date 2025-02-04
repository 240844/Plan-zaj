package com.example.zpo.dtos;

import java.time.LocalTime;
import java.util.List;

public record HourSlotDTO(
        String hour,
        List<ClassDTO> classes
) {
}
