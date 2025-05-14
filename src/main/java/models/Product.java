package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {

    //private long id;

    private String title;

    private double price;

    private String description;

    private Category category;


}
