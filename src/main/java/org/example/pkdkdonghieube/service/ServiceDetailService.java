package org.example.pkdkdonghieube.service;

import org.example.pkdkdonghieube.entity.ServiceDetail;
import org.example.pkdkdonghieube.entity.Services;
import org.example.pkdkdonghieube.repository.ServiceDetailRepository;
import org.example.pkdkdonghieube.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDetailService {

    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceDetail> saveAll(List<ServiceDetail> serviceDetails, Long serviceId) {
        Services service = serviceRepository.findById(serviceId).orElseThrow(
                () -> new RuntimeException("Service ID không tồn tại"));

        for (ServiceDetail detail : serviceDetails) {
            detail.setService(service);
        }
        return serviceDetailRepository.saveAll(serviceDetails);
    }
}