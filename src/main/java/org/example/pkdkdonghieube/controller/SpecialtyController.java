package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.Specialty;
import org.example.pkdkdonghieube.service.SpecialtyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @PostMapping
    public ResponseEntity<Specialty> createSpecialty(@RequestBody Specialty specialty) {
        return ResponseEntity.ok(specialtyService.createSpecialty(specialty));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Specialty>> createSpecialties(@RequestBody List<Specialty> specialties) {
        List<Specialty> savedSpecialties = specialtyService.saveAll(specialties);
        return ResponseEntity.ok(savedSpecialties);
    }

}
