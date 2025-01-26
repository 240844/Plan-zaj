package com.example.zpo;

import com.example.zpo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class ZpoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZpoApplication.class, args);
    }

    @GetMapping
    public List<Student> Hello(){
        return List.of(
                new Student(1L,"Jan", 1L),
                new Student(1L,"Zan", 1L)
        );
    }
}
