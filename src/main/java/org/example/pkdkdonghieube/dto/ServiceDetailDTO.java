package org.example.pkdkdonghieube.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDetailDTO {
    private Long id;
    private String detail;
    private Double price;
    private Double insurancePrice;
    public ServiceDetailDTO() {
    }

    public ServiceDetailDTO(String detail, Double price) {
        this.detail = detail;
        this.price = price;
    }

    public ServiceDetailDTO(String detail, Double price, Double insurancePrice) {
        this.detail = detail;
        this.price = price;
        this.insurancePrice = insurancePrice;
    }

    public Double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(Double insurancePrice) {
        this.insurancePrice = insurancePrice;
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
