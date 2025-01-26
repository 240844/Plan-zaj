package com.example.zpo.student;

/**
 * Class for representing university/collage students.
 */
public class Student {

    private Long id;
    private String name;
    private Long group_id;

    public Student(Long group_id, String name, Long id) {
        this.group_id = group_id;
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    public Student(String name, Long group_id) {
        this.name = name;
        this.group_id = group_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getGroup_id() {
        return group_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_id=" + group_id +
                '}';
    }
}
