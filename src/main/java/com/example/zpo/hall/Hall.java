package com.example.zpo.hall;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    private Long id;
    private Long building_id;
    private String hall_name;

    public Hall() {
    }

    public Hall(Long id, Long building_id, String hall_name) {
        this.id = id;
        this.building_id = building_id;
        this.hall_name = hall_name;
    }

    public Hall(Long building_id, String hall_name) {
        this.building_id = building_id;
        this.hall_name = hall_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Long building_id) {
        this.building_id = building_id;
    }

    public String getHall_name() {
        return hall_name;
    }

    public void setHall_name(String hall_name) {
        this.hall_name = hall_name;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", building_id=" + building_id +
                ", hall_name='" + hall_name + '\'' +
                '}';
    }
}
