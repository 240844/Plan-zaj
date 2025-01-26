package com.example.zpo.student;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service component for student
 */
@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L, "Jan", 1L),
                new Student(1L, "Dan", 2L)
        );
    }

}
