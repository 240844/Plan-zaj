package com.example.zpo.repositories;

import com.example.zpo.daos.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository
        extends JpaRepository<Hall, Long> {
}
