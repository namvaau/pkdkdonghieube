package org.example.pkdkdonghieube.mapper;

import org.example.pkdkdonghieube.dto.ServiceDTO;
import org.example.pkdkdonghieube.dto.ServiceDetailDTO;
import org.example.pkdkdonghieube.entity.Services;
import org.example.pkdkdonghieube.entity.ServiceDetail;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceMapper {
    public static ServiceDTO toDTO(Services service) {
        ServiceDTO dto = new ServiceDTO();
        dto.setId(service.getId());
        dto.setName(service.getName());
        dto.setDescription(service.getDescription());

        List<ServiceDetailDTO> detailDTOs = service.getServiceDetails().stream()
                .map(ServiceMapper::toDetailDTO)
                .collect(Collectors.toList());

        dto.setServiceDetails(detailDTOs);
        return dto;
    }

    public static ServiceDetailDTO toDetailDTO(ServiceDetail detail) {
        ServiceDetailDTO dto = new ServiceDetailDTO();
        dto.setId(detail.getId());
        dto.setDetail(detail.getDetail());
        dto.setPrice(detail.getPrice());
        return dto;
    }
}
