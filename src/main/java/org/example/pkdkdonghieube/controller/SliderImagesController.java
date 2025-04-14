package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.SliderImages;
import org.example.pkdkdonghieube.repository.SliderImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sliderimages")
public class SliderImagesController {
    @Autowired
    private SliderImagesRepository sliderImagesRepository;

    @PostMapping
    public ResponseEntity<SliderImages> createImages(@RequestBody SliderImages sliderImages) {
        SliderImages saveImages = sliderImagesRepository.save(sliderImages);
        return ResponseEntity.ok(saveImages);
    }
    @GetMapping
    public List<SliderImages> getAllSliderImages() {
        return sliderImagesRepository.findAll();
    }
}
