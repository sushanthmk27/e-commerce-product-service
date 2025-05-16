package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

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
