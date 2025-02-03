package com.example.zpo.repositories;

import com.example.zpo.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository
        extends JpaRepository<Professor, Long> {

}
