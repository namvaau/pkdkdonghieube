package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.dto.ServiceDetailDTO;
import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.example.pkdkdonghieube.entity.Services;
import org.example.pkdkdonghieube.repository.ServiceDetailRepository;
import org.example.pkdkdonghieube.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesService {
    private final ServiceRepository serviceRepository;
    private final ServiceDetailRepository serviceDetailRepository;

    public ServicesService(ServiceRepository serviceRepository, ServiceDetailRepository serviceDetailRepository) {
        this.serviceRepository = serviceRepository;
        this.serviceDetailRepository = serviceDetailRepository;
    }

    public List<Services> getAllServices() {
        return serviceRepository.findAll();
    }

    public Services getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public List<ServiceDetailDTO> getServiceDetailsByServiceId(Long serviceId) {
        List<ServiceDetail> details = serviceDetailRepository.findByServiceId(serviceId);
        return details.stream()
                .map(detail -> new ServiceDetailDTO(detail.getDetail(), detail.getPrice()))
                .collect(Collectors.toList());
    }

}
