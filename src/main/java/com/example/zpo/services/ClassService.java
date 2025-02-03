package com.example.zpo.services;

import com.example.zpo.daos.UniversityClass;
import com.example.zpo.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<UniversityClass> getAll() {
        return classRepository.findAll();
    }

    public Optional<UniversityClass> getByID(Long id) {
        return classRepository.findById(id);
    }

}
