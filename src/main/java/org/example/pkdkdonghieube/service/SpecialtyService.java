package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.entity.Specialty;
import org.example.pkdkdonghieube.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public List<Specialty> saveAll(List<Specialty> specialties) {
        return specialtyRepository.saveAll(specialties);
    }
}