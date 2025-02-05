package com.example.zpo.controllers;

import com.example.zpo.dtos.ScheduleDTO;
import com.example.zpo.services.GroupService;
import com.example.zpo.services.ProfessorService;
import com.example.zpo.services.ScheduleService;
import com.example.zpo.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
TODO:
    4. Fix classDTO to have building, and add it to mapper and toString
    5. Change professor id to ID NAME
    6. Change group id to ID NAME
    7. Add seeking lectures in
 */

@Controller
@RequestMapping("/selection")
public class SelectionController {

    private final ProfessorService professorService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final List<String> categories = List.of("Professor", "Group", "Student");
    private final ScheduleService scheduleService;

    @Autowired
    public SelectionController(ProfessorService professorService,
                               GroupService groupService,
                               StudentService studentService,
                               ScheduleService scheduleService) {
        this.professorService = professorService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public String showSelectionPage(Model model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> categoryMap = new HashMap<>();

        for (String category : categories) {
            List<String> id = switch (category) {
                case "Professor" ->
                        professorService.getProfessors().stream().map(professor -> String.valueOf(professor.getId())).toList();
                case "Group" ->
                        groupService.getAllGroups().stream().map(group -> String.valueOf(group.getId())).toList();
                case "Student" ->
                        studentService.getStudents().stream().map(student -> String.valueOf(student.getId())).toList();
                default -> new ArrayList<>();
            };
            categoryMap.put(category, id);
        }

        model.addAttribute("categories", categories);
        model.addAttribute("idOptions", mapper.writeValueAsString(categoryMap));

        return "selectionPage";
    }

    @PostMapping
    public String handleSelection(
            @RequestParam String category,
            @RequestParam String selectedId,
            Model model) {
        System.out.println("ID " + selectedId);
        ScheduleDTO schedule = switch (category) {
            case "Professor" ->
                    scheduleService.getScheduleForProfessor(Long.parseLong(selectedId));
            case "Group" ->
                    scheduleService.getScheduleForGroup(Long.parseLong(selectedId));
            case "Student" ->
                    scheduleService.getScheduleForStudent(Long.parseLong(selectedId));
            default -> null;
        };
        model.addAttribute("message", "You selected: " + category + " with ID: " + selectedId);
        model.addAttribute("schedule", schedule);
        return "resultPage";
    }

}
