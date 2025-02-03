package com.example.zpo.controllers;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "plan/class")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<ClassDTO> getClasses() {
        return classService.getAll();
    }

}
