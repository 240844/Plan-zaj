package com.example.zpo.services;

import com.example.zpo.daos.Hall;
import com.example.zpo.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getHalls() {
        return hallRepository.findAll();
    }

    public Optional<Hall> getHall(Long id) {
        return hallRepository.findById(id);
    }

}
