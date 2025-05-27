package com.scaler.productservice.service;

import com.scaler.productservice.models.Product;
import com.scaler.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
/*@Primary */ // This annotation indicates that this service should be the primary bean of its type - this is one of the solutions to the issue of multiple beans of the same type in the Spring context.
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    private SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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
