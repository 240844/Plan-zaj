package com.example.zpo.repositories;

import com.example.zpo.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository
        extends JpaRepository<Hall, Long> {
}
