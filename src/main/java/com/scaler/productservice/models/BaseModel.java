package com.scaler.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Represents the base model for all entities in the application.
 * This model provides common properties that are inherited by all extending models.
 *
 * Fields:
 * - {@code id}: A unique identifier for the entity.
 * - {@code createdAt}: The timestamp indicating when the entity was created.
 * - {@code lastModifiedAt}: The timestamp indicating when the entity was last modified.
 *
 * This class is abstract and cannot be instantiated directly.
 * It is intended to enforce a consistent structure for models in the application.
 */
@Getter
@Setter
public abstract class BaseModel {

    private Long id;

    private Date createdAt;

    private Date lastModifiedAt;
}
