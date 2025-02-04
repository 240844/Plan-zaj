package com.example.zpo.services;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.entity.Group;
import com.example.zpo.entity.Hall;
import com.example.zpo.entity.Professor;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.mappers.ClassDTOMapper;
import com.example.zpo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassService {

    private final ClassRepository classRepository;
    private final ClassDTOMapper classDTOMapper;

    @Autowired
    public ClassService(ClassRepository classRepository,
                        ClassDTOMapper classDTOMapper) {
        this.classRepository = classRepository;
        this.classDTOMapper = classDTOMapper;
    }

    public List<ClassDTO> getAll() {
        return classRepository.findAll()
                .stream()
                .map(classDTOMapper
                ).collect(Collectors.toList());
    }

    public List<UniversityClass> getByProfessorID(Long id){
        return classRepository.findByGroupID(id);
    }

    public List<UniversityClass> getByGroupID(Long id){
        return classRepository.findByGroupID(id);
    }

    public Optional<UniversityClass> getByID(Long id) {
        return classRepository.findById(id);
    }

}
