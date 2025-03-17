package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.entity.Doctor;
import org.example.pkdkdonghieube.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorDescription(Long id, String newDescription) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setDescription(newDescription);
                    return doctorRepository.save(doctor);
                })
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public Doctor updateSpeciality(Long id, String speciality) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.setSpeciality(speciality);
        return doctorRepository.save(doctor);
    }


}