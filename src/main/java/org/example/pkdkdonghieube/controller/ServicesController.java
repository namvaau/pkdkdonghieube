package org.example.pkdkdonghieube.controller;

import org.example.pkdkdonghieube.dto.ServiceDTO;
import org.example.pkdkdonghieube.dto.ServiceDetailDTO;
import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.example.pkdkdonghieube.entity.Services;
import org.example.pkdkdonghieube.mapper.ServiceMapper;
import org.example.pkdkdonghieube.service.ServicesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private final ServicesService serviceService;

    public ServicesController(ServicesService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<ServiceDTO> getAllServices() {
        List<Services> services = serviceService.getAllServices();
        return services.stream()
                .map(ServiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable Long id) {
        Services service = serviceService.getServiceById(id);
        return ResponseEntity.ok(new ServiceDTO(service));
    }

    @GetMapping("/{id}/details")
    public List<ServiceDetailDTO> getServiceDetailsByServiceId(@PathVariable Long id) {
        List<ServiceDetailDTO> details = serviceService.getServiceDetailsByServiceId(id);
        return (details);
    }

}

