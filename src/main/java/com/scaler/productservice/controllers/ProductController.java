package com.scaler.productservice.controllers;

import models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return new Product();
    }

    // Note: When we have the same mapping signature, the method will be called based on the http type of the method. Ex: Get, Post ...
    // If the incoming request is a get call then the respective method will be triggerred. If the incoming method is a post call the n the respective method gets triggered.
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    // Note: When we have the same mapping signature the method will be called based on the http type of the method. Ex: Get, Post ...
    @PostMapping("/")
    public Product createProduct(Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long prodId){

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long prodId){

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replaceProduct(@PathVariable("id") Long productId){

    }
}
