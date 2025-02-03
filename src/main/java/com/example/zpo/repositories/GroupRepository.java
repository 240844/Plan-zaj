package com.example.zpo.repositories;

import com.example.zpo.daos.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository
    extends JpaRepository<Group, Long> {
}
