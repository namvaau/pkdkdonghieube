package org.example.pkdkdonghieube.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.pkdkdonghieube.entity.Services;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private List<ServiceDetailDTO> serviceDetails;


    public ServiceDTO() {
    }

    public ServiceDTO(Services service) {
        this.id = service.getId();
        this.name = service.getName();
        this.description = service.getDescription();
        this.serviceDetails = service.getServiceDetails()
                .stream()
                .map(detail -> new ServiceDetailDTO(detail.getDetail(), detail.getPrice()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ServiceDetailDTO> getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(List<ServiceDetailDTO> serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
