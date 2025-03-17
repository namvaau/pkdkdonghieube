package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.Doctor;
import org.example.pkdkdonghieube.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @PatchMapping("/{id}/description")
    public ResponseEntity<Doctor> updateDoctorDescription(@PathVariable Long id, @RequestBody String newDescription) {
        Doctor updatedDoctor = doctorService.updateDoctorDescription(id, newDescription);
        return ResponseEntity.ok(updatedDoctor);
    }

    @PatchMapping("/{id}/speciality")
    public ResponseEntity<Doctor> updateSpeciality(@PathVariable Long id, @RequestBody String speciality) {
        Doctor updatedDoctor = doctorService.updateSpeciality(id, speciality);
        return ResponseEntity.ok(updatedDoctor);
    }


}