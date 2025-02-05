package com.example.zpo.mappers;

import com.example.zpo.dtos.ClassDTO;
import com.example.zpo.entity.Group;
import com.example.zpo.entity.Hall;
import com.example.zpo.entity.Professor;
import com.example.zpo.entity.UniversityClass;
import com.example.zpo.repositories.BuildingRepository;
import com.example.zpo.repositories.GroupRepository;
import com.example.zpo.repositories.HallRepository;
import com.example.zpo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClassDTOMapper implements Function<UniversityClass, ClassDTO> {

    private final ProfessorRepository professorRepository;
    private final GroupRepository groupRepository;
    private final HallRepository hallRepository;
    private final BuildingRepository buildingRepository;

    @Autowired
    public ClassDTOMapper(ProfessorRepository professorRepository,
                    GroupRepository groupRepository,
                    HallRepository hallRepository,
                    BuildingRepository buildingRepository)
    {
        this.professorRepository = professorRepository;
        this.buildingRepository = buildingRepository;
        this.hallRepository = hallRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public ClassDTO apply(UniversityClass universityClass){
        return new ClassDTO(
                universityClass.getName(),
                professorRepository.findById(universityClass.getProfessorID())
                        .map(Professor::getName)
                        .orElse("No Professor Found"),
                groupRepository.findById(universityClass.getGroupID())
                        .map(Group::getGroup_name)
                        .orElse("No group Found"),
                universityClass.getTypeAsString(),
                hallRepository.findById(universityClass.getHallID())
                        .map(Hall::getHall_name)
                        .orElse("No hall found")
                );
    }

}
