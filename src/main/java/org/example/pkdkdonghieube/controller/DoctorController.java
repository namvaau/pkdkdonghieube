package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.Doctor;
import org.example.pkdkdonghieube.repository.DoctorRepository;
import org.example.pkdkdonghieube.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

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

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        Optional<Doctor> existingDoctorOpt = doctorService.getDoctorById(id);

        if (existingDoctorOpt.isPresent()) {
            Doctor existingDoctor = existingDoctorOpt.get();

            // Cập nhật thông tin
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setExperience(updatedDoctor.getExperience());
            existingDoctor.setDescription(updatedDoctor.getDescription());
            existingDoctor.setImageUrl(updatedDoctor.getImageUrl());
            existingDoctor.setSpeciality(updatedDoctor.getSpeciality());

            // Lưu lại vào database
            Doctor savedDoctor = doctorService.saveDoctor(existingDoctor);
            return ResponseEntity.ok(savedDoctor);
        } else {
            return ResponseEntity.notFound().build(); // 404 nếu không tìm thấy
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            doctorRepository.deleteById(id);
            return ResponseEntity.ok("Bác sĩ đã được xóa thành công!");
        }
        return ResponseEntity.status(404).body("Không tìm thấy bác sĩ!");
    }


}