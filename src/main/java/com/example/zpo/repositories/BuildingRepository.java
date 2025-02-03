package com.example.zpo.repositories;

import com.example.zpo.daos.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository
        extends JpaRepository<Building, Long> {
}
