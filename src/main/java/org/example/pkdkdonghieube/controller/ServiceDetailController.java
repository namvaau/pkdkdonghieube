package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.example.pkdkdonghieube.service.ServiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-details")
public class ServiceDetailController {

    @Autowired
    private ServiceDetailService serviceDetailService;

    @PostMapping("/{serviceId}")
    public ResponseEntity<List<ServiceDetail>> createServiceDetails(
            @PathVariable Long serviceId,
            @RequestBody List<ServiceDetail> serviceDetails) {

        List<ServiceDetail> savedDetails = serviceDetailService.saveAll(serviceDetails, serviceId);
        return ResponseEntity.ok(savedDetails);
    }
}