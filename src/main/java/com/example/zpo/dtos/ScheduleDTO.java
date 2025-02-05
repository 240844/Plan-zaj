package com.example.zpo.dtos;

import java.util.List;

public record ScheduleDTO(
        List<HourSlotDTO> weeklySchedule
) {
    @Override
    public String toString() {
        StringBuilder scheduleJson = new StringBuilder("[");
        for (HourSlotDTO hourSlot : weeklySchedule) {
            scheduleJson.append(hourSlot.toString()).append(", ");
        }

        if (!weeklySchedule.isEmpty()) {
            scheduleJson.setLength(scheduleJson.length() - 2);
        }

        scheduleJson.append("]");

        return String.format(
                "{ \"weeklySchedule\": %s }",
                scheduleJson.toString()
        );
    }
}
