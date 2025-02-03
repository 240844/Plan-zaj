package com.example.zpo.daos;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "classes")
public class UniversityClass {

    @Id
    private Long id;
    private Long hall_id;
    private Long professor_id;
    private Long group_id;
    @Column(name = "time_start")
    private LocalTime start_time;
    private Long duration; //Duration of class in minutes
    private Long class_type;
    private String day_of_week;

    public UniversityClass(Long id, Long hall_id, Long professor_id, Long group_id, LocalTime start_time, Long duration,
                           Long class_type, String day_of_week) {
        this.id = id;
        this.hall_id = hall_id;
        this.professor_id = professor_id;
        this.group_id = group_id;
        this.start_time = start_time;
        this.duration = duration;
        this.class_type = class_type;
        this.day_of_week = day_of_week;
    }

    public UniversityClass(Long hall_id, Long professor_id, Long group_id, LocalTime start_time, Long duration,
                           Long class_type, String day_of_week) {
        this.hall_id = hall_id;
        this.professor_id = professor_id;
        this.group_id = group_id;
        this.start_time = start_time;
        this.duration = duration;
        this.class_type = class_type;
        this.day_of_week = day_of_week;
    }

    public UniversityClass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHall_id() {
        return hall_id;
    }

    public void setHall_id(Long hall_id) {
        this.hall_id = hall_id;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getClass_type() {
        return class_type;
    }

    public void setClass_type(Long class_type) {
        this.class_type = class_type;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    @Override
    public String toString() {
        return "UniversityClass{" +
                "id=" + id +
                ", hall_id=" + hall_id +
                ", professor_id=" + professor_id +
                ", group_id=" + group_id +
                ", start_time=" + start_time +
                ", duration=" + duration +
                ", class_type=" + class_type +
                ", day_of_week='" + day_of_week +
                '}';
    }
}
