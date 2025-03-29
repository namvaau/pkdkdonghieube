package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.entity.SpecialtyDetail;
import org.example.pkdkdonghieube.repository.SpecialtyDetailRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecialtyDetailService {
    private final SpecialtyDetailRepository specialtyDetailRepository;

    public SpecialtyDetailService(SpecialtyDetailRepository specialtyDetailRepository) {
        this.specialtyDetailRepository = specialtyDetailRepository;
    }

    public Optional<SpecialtyDetail> findBySpecialtyId(Long specialtyId) {
        return specialtyDetailRepository.findBySpecialtyId(specialtyId);
    }
}
