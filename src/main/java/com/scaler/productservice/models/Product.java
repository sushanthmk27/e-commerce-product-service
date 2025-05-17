package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents a product with various attributes including title, price,
 * description, associated image, and category. This class extends {@code BaseModel}
 * to include properties such as ID, creation time, and last modification time.
 *
 * This model is used to define the structure of the product entity and is
 * primarily utilized in the product-related services for operations like retrieval,
 * creation, update, and deletion.
 *
 * Fields:
 * - {@code title}: The name or title of the product.
 * - {@code price}: The cost of the product, represented as a double.
 * - {@code description}: A detailed description of the product.
 * - {@code image}: URL or identifier for the product image.
 * - {@code category}: The category to which the product belongs, represented as an instance of {@code Category}.
 */
@Getter
@Setter
public class Product extends BaseModel {

    //private long id;

    private String title;

    private double price;

    private String description;

    private String image;

    private Category category;


}
