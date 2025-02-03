package com.example.zpo.repositories;

import com.example.zpo.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository
        extends JpaRepository<Building, Long> {
}
