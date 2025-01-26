package com.example.zpo.professor;

import com.example.zpo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessor(Long id) {
        return professorRepository.findById(id);
    }

}
