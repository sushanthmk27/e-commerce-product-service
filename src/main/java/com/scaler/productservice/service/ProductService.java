package com.scaler.productservice.service;

import models.Product;

import java.util.List;

public interface ProductService {

     Product getSingleProduct(Long id);

     List<Product> getAllProducts();

     Product createProduct(Product product);

     boolean deleteProduct(Long prodId);

     boolean updateProduct(Long prodId);

     boolean replaceProduct(Long productId);
}
