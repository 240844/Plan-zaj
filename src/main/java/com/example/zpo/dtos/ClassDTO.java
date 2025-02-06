package com.example.zpo.dtos;

public record ClassDTO(
        String subjectName,
        String professorName,
        String groupName,
        String type,
        String hall,
        String building
) {

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("{\n");

        output.append("\"subjectName\": \"").append(subjectName).append("\",\n");
        output.append("\"professorName\": \"").append(professorName).append("\",\n");
        output.append("\"groupName\": \"").append(groupName).append("\",\n");
        output.append("\"type\": \"").append(type).append("\",\n");
        output.append("\"building\": \"").append(building).append("\",\n");
        output.append("\"hall\": \"").append(hall).append("\"\n");

        output.append("}");
        return output.toString();
    }
}
