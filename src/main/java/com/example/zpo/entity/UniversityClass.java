package com.example.zpo.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "classes")
public class UniversityClass {

    @Id
    private Long id;
    @Column(name = "hall_id")
    private Long hallID;
    @Column(name = "professor_id")
    private Long professorID;
    @Column(name = "group_id")
    private Long groupID;
    @Column(name = "time_start")
    private LocalTime start_time;
    private Long duration; //Duration of class in minutes
    private Long class_type;
    private String day_of_week;
    @Column(name = "name")
    private String nameOfClass;
    @Column(name = "lecture_id")
    private Long lectureID;

    public UniversityClass(Long id, Long hallID, Long professorID, Long groupID, LocalTime start_time, Long duration,
                           Long class_type, String day_of_week, String nameOfClass, Long lectureID) {
        this.id = id;
        this.hallID = hallID;
        this.professorID = professorID;
        this.groupID = groupID;
        this.start_time = start_time;
        this.duration = duration;
        this.class_type = class_type;
        this.day_of_week = day_of_week;
        this.nameOfClass = nameOfClass;
        this.lectureID = lectureID;
    }

    public UniversityClass(Long hallID, Long professorID, Long groupID, LocalTime start_time, Long duration,
                           Long class_type, String day_of_week, String nameOfClass, Long lectureID) {
        this.hallID = hallID;
        this.professorID = professorID;
        this.groupID = groupID;
        this.start_time = start_time;
        this.duration = duration;
        this.class_type = class_type;
        this.day_of_week = day_of_week;
        this.nameOfClass = nameOfClass;
        this.lectureID = lectureID;
    }

    public UniversityClass() {
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return nameOfClass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHallID() {
        return hallID;
    }

    public void setHallID(Long hall_id) {
        this.hallID = hall_id;
    }

    public Long getProfessorID() {
        return professorID;
    }

    public void setProfessorID(Long professor_id) {
        this.professorID = professor_id;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long group_id) {
        this.groupID = group_id;
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

    public String getTypeAsString(){
        return switch (this.class_type.intValue()) {
            case 2 -> "Lab.";
            case 3 -> "Cw.";
            default -> "Wyk.";
        };
    }

    @Override
    public String toString() {
        return "UniversityClass{" +
                "id=" + id +
                ", hall_id=" + hallID +
                ", professor_id=" + professorID +
                ", group_id=" + groupID +
                ", start_time=" + start_time +
                ", duration=" + duration +
                ", class_type=" + class_type +
                ", day_of_week='" + day_of_week +
                '}';
    }
}
