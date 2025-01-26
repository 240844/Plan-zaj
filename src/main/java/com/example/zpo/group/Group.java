package com.example.zpo.group;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    private Long id;
    private String group_name;

    public Group(Long id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }

    public Group(String group_name) {
        this.group_name = group_name;
    }

    public Group() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
