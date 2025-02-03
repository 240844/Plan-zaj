package com.example.zpo.entity;

import jakarta.persistence.*;

/**
 * Class for representing university/collage students.
 */

@Entity
@Table(name = "students")
public class Student {

    @Id
    /*
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
     */
    private Long id;
    private String name;
    @Column(name = "group_id")
    private Long groupID;

    public Student(Long groupID, String name, Long id) {
        this.groupID = groupID;
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    public Student(String name, Long groupID) {
        this.name = name;
        this.groupID = groupID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupID(Long group_id) {
        this.groupID = group_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getGroupID() {
        return groupID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_id=" + groupID +
                '}';
    }
}
