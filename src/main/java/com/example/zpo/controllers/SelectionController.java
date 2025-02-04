package com.example.zpo.controllers;

import com.example.zpo.entity.Group;
import com.example.zpo.entity.Professor;
import com.example.zpo.entity.Student;
import com.example.zpo.services.GroupService;
import com.example.zpo.services.ProfessorService;
import com.example.zpo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/selection")
public class SelectionController {

    private final ProfessorService professorService;
    private final GroupService groupService;
    private final StudentService studentService;

    @Autowired
    public SelectionController(ProfessorService professorService,
                               GroupService groupService,
                               StudentService studentService){
        this.professorService = professorService;
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping
    public String showSelectionPage(Model model) {
        // List of categories
        List<String> categories = List.of("Professor", "Group", "Student");

        // Example data for IDs
        Map<String, List<String>> idOptions = new HashMap<>();
        idOptions.put("Professor", professorService.getProfessors().stream().map(professor -> String.valueOf(professor.getId())).toList());
        idOptions.put("Group", groupService.getAllGroups().stream().map(group -> String.valueOf(group.getId())).toList());
        idOptions.put("Student", studentService.getStudents().stream().map(student -> String.valueOf(student.getId())).toList());

        professorService.getProfessors().stream().map(professor -> String.valueOf(professor.getId())).toList().forEach(System.out::println);
        groupService.getAllGroups().stream().map(group -> String.valueOf(group.getId())).toList().forEach(System.out::println);
        model.addAttribute("categories", categories);
        model.addAttribute("idOptions", idOptions);

        return "selectionPage";
    }

    @PostMapping
    public String handleSelection(
            @RequestParam String category,
            @RequestParam String selectedId,
            Model model) {
        model.addAttribute("message", "You selected: " + category + " with ID: " + selectedId);
        return "resultPage";
    }

}
