package com.example.zpo.daos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "building")
public class Building {

    @Id
    private Long id;
    private String name;

    public Building(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Building() {
    }

    public Building(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
