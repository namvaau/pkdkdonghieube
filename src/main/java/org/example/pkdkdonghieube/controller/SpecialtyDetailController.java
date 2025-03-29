package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.SpecialtyDetail;
import org.example.pkdkdonghieube.service.SpecialtyDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/specialty-details")
public class SpecialtyDetailController {
    private final SpecialtyDetailService specialtyDetailService;

    public SpecialtyDetailController(SpecialtyDetailService specialtyDetailService) {
        this.specialtyDetailService = specialtyDetailService;
    }

    @GetMapping("/{specialtyId}")
    public ResponseEntity<SpecialtyDetail> getSpecialtyDetailBySpecialtyId(@PathVariable Long specialtyId) {
        return specialtyDetailService.findBySpecialtyId(specialtyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
