package org.example.pkdkdonghieube.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDetailDTO {
    private Long id;
    private String detail;
    private Double price;

    public ServiceDetailDTO() {
    }

    public ServiceDetailDTO(String detail, Double price) {
        this.detail = detail;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
