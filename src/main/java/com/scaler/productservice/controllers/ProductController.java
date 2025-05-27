package com.scaler.productservice.controllers;

import com.scaler.productservice.service.ProductService;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsible for handling product-related HTTP requests.
 * Provides endpoints for retrieving, creating, updating, replacing, and deleting products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

   // @Autowired    <-- not required
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    /**
     * Retrieves a single product by its unique identifier.
     *
     * @param id the unique identifier of the product to retrieve
     * @return a ResponseEntity containing the Product if found,
     *         or a 404 Not Found status if the product is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product>getSingleProduct(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity = null;
        Product product = null;
        try{
            product= productService.getSingleProduct(id);
            responseEntity = ResponseEntity.ok(product);
            return responseEntity;
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Retrieves a list of all available products.
     *
     * @return a list of Product objects representing all products
     */
    // Note: When we have the same mapping signature, the method will be called based on the http type of the method. Ex: Get, Post ...
    // If the incoming request is a get call then the respective method will be triggerred. If the incoming method is a post call the n the respective method gets triggered.
    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // Note: When we have the same mapping signature the method will be called based on the http type of the method. Ex: Get, Post ...
    @PostMapping("/")
    public Product createProduct(Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long prodId){
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Long prodId){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replaceProduct(@PathVariable("id") Long productId){
        return null;
    }
}
