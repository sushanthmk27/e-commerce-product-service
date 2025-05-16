package com.scaler.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceResponseDTO {

    private Long id;

    private String title;

    private Double price;

    private String description;

    private String image;

    private String category;
}
