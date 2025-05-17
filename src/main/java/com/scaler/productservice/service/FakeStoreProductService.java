package com.scaler.productservice.service;

import com.scaler.productservice.dto.ProductServiceResponseDTO;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service implementation for managing products using the FakeStore API.
 * It provides methods to retrieve a single product, retrieve all products,
 * and placeholder methods for creating, deleting, updating,
 * and replacing products.
 */
@Service
//@Component   <-- Can be used since this is a Super to @Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves a single product by its ID using the FakeStore API.
     *
     * @param productId the ID of the product to retrieve
     * @return the product retrieved from the FakeStore API, or null if no product is found
     */
    @Override
    public Product getSingleProduct(Long productId) {
      //  /*RestTemplate restTemplate = new RestTemplate();*/

        ResponseEntity<ProductServiceResponseDTO> responseDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + productId,
                    ProductServiceResponseDTO.class);
        ProductServiceResponseDTO productServiceResponseDTO = responseDto.getBody();
        return convertToProduct(productServiceResponseDTO);
    }

    /**
     * Retrieves and returns a list of all products from the FakeStore API.
     *
     * This method makes a call to an external API to fetch product data,
     * processes the response, and converts it into a list of {@link Product} objects.
     *
     * @return a list of {@link Product} objects retrieved from the API,
     *         or an empty list if no products are available.
     */
    @Override
    public List<Product> getAllProducts() {
        //This gives us error due to the concept of Generics Type Erasure during runtime
        /*ResponseEntity<List<ProductServiceResponseDTO>> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                List<ProductServiceResponseDTO>.class          <-- This is not allowed
        );*/

        /*ResponseEntity<List> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                List.class      <-- This is not a good practice as this is not type safe and can cause compile time errors
        );*/

        ResponseEntity<ProductServiceResponseDTO[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductServiceResponseDTO[].class       // <- In this scenario its a good practice to use Array rather than List
        );
        ProductServiceResponseDTO[] productResponseArr = response.getBody();
        List<Product> responseList = new ArrayList<>();
        if (productResponseArr != null) {
            for(ProductServiceResponseDTO productServiceResponseDTO : productResponseArr){
                responseList.add(convertToProduct(productServiceResponseDTO));
            }
        }
        return responseList;
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

    /**
     * Converts a {@code ProductServiceResponseDTO} object to a {@code Product} object.
     * This method maps the fields from the input Data Transfer Object (DTO) to a new Product instance,
     * including its associated {@code Category}.
     *
     * @param productServiceResponseDTO the {@code ProductServiceResponseDTO} object to be converted;
     *                                   may be {@code null}.
     * @return the {@code Product} object created from the input DTO, or {@code null} if the input is {@code null}.
     */
    //This method is used to convert the incoming responseDto to the respective Product mapping
    private static Product convertToProduct(ProductServiceResponseDTO productServiceResponseDTO){
        if(productServiceResponseDTO == null){
            return null;
        }
        // Convert ProductServiceResponseDTO to Product
        Product product = new Product();
        product.setId(productServiceResponseDTO.getId());
        product.setTitle(productServiceResponseDTO.getTitle());
        product.setPrice(productServiceResponseDTO.getPrice());
        product.setDescription(productServiceResponseDTO.getDescription());
        product.setImage(productServiceResponseDTO.getImage());

        Category category = new Category();
        category.setCategoryName(productServiceResponseDTO.getCategory());

        product.setCategory(category);
        return product;
    }

}
