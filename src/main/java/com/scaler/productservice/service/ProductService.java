package com.scaler.productservice.service;

import com.scaler.productservice.models.Product;

import java.util.List;

/**
 * The ProductService interface defines methods for managing products.
 * It provides methods to retrieve, create, delete, update, and replace products.
 */
public interface ProductService {

     Product getSingleProduct(Long id);

     List<Product> getAllProducts();

     Product createProduct(Product product);

     boolean deleteProduct(Long prodId);

     boolean updateProduct(Long prodId);

     boolean replaceProduct(Long productId);
}
