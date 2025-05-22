package com.scaler.productservice.service;

import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{
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
