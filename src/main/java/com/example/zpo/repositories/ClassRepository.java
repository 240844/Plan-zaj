package com.example.zpo.repositories;

import com.example.zpo.daos.UniversityClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository
        extends JpaRepository<UniversityClass, Long> {
}
