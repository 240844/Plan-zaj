package com.example.zpo.university_class;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "classes")
public class UniversityClass {

    @Id
    private Long id;
    private Long hall_id;
    private Long professor_id;
    private Long group_id;
    private LocalTime start_time;
    private Long duration; //Duration of class in minutes
    private Long class_type;
    private String day_of_week;
    private String name;

}
