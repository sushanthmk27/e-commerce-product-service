package com.scaler.productservice.service;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@Component   <-- Can be used since this is a Super to @Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
      //  /*RestTemplate restTemplate = new RestTemplate();*/

        restTemplate.getForEntity("https://fakestoreapi.com/products" +productId, Product.class);
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
