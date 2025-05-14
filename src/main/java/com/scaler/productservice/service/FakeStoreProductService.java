package com.scaler.productservice.service;

import models.Product;

import java.util.List;

public class FakeStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long prodId) {
        return false;
    }

    @Override
    public boolean updateProduct(Long prodId) {
        return false;
    }

    @Override
    public boolean replaceProduct(Long productId) {
        return false;
    }
}
