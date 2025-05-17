package com.scaler.productservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing the response of a product service.
 *
 * This class is utilized to store and transfer product data received from external
 * product service APIs, such as the FakeStore API.
 *
 * Fields:
 * - id: The unique identifier of the product.
 * - title: The title or name of the product.
 * - price: The price of the product.
 * - description: A detailed description of the product.
 * - image: The URL of the image associated with the product.
 * - category: The category to which the product belongs.
 *
 * The fields in this class correspond directly to the structure of the data
 * retrieved from the external service and are mapped accordingly.
 */
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
