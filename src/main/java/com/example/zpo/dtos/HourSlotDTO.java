package com.example.zpo.dtos;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public record HourSlotDTO(
        String hour,
        HashMap<String, ClassDTO> classes
) {
}
