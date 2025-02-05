package com.example.zpo.dtos;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public record HourSlotDTO(
        String hour,
        HashMap<String, ClassDTO> classes
) {

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{");

        output.append("\"hour\": \"").append(hour).append("\",\n");
        output.append("\"classes\": ").append("{\n");

        classes.forEach((key, classDTO) -> {
                    output.append(String.format("\"%s\": %s\n",
                            key, classDTO != null ? classDTO.toString() : "null"));
                    if (key == "Sunday") {
                        output.append("\n");
                    } else {
                        output.append(",\n");
                    }
                }
        );
        System.out.println(output.toString());
        return output.toString();
    }
}
