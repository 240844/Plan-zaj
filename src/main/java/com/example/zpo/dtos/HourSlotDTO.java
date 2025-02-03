package com.example.zpo.dtos;

import java.time.LocalTime;
import java.util.List;

public record HourSlotDTO(
        LocalTime hour,
        List<ClassDTO> classes
) {
}
