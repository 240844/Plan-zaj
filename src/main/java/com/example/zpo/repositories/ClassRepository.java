package com.example.zpo.repositories;

import java.util.List;
import com.example.zpo.entity.UniversityClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassRepository
        extends JpaRepository<UniversityClass, Long> {

    @Query("SELECT c FROM UniversityClass c WHERE c.groupID = ?1")
    List<UniversityClass> findByGroupID(Long groupID);

    @Query("SELECT c FROM UniversityClass c WHERE c.groupID = ?1")
    List<UniversityClass> findByProfessorID(Long professorID);

    @Query("SELECT c FROM UniversityClass c WHERE c.hallID = ?1")
    List<UniversityClass> findByHallID(Long hallID);

    @Query("SELECT c FROM UniversityClass c JOIN Student s ON c.groupID = s.groupID WHERE s.id = ?1")
    List<UniversityClass> findClassesByStudentId(Long studentId);

}
