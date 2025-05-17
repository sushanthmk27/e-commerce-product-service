package com.scaler.productservice.exceptions;

/**
 * A custom exception that is thrown when a product cannot be found.
 * This exception extends {@code RuntimeException}, allowing it to be used
 * to indicate an error state specific to product lookups or retrievals.
 *
 * The exception should be instantiated with a message describing the
 * specific details of the product not found scenario.
 */
public class ProductNotFoundException  extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
