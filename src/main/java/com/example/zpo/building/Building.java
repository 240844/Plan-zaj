package com.example.zpo.building;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "building")
public class Building {

    @Id
    private Long id;
    private String name;
}
