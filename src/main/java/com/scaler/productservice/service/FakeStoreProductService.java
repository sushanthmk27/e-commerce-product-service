package com.scaler.productservice.service;

import com.scaler.productservice.dto.ProductServiceResponseDTO;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@Component   <-- Can be used since this is a Super to @Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
      //  /*RestTemplate restTemplate = new RestTemplate();*/

        ResponseEntity<ProductServiceResponseDTO> responseDto = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, ProductServiceResponseDTO.class);
        ProductServiceResponseDTO productServiceResponseDTO = responseDto.getBody();
        return convertToProduct(productServiceResponseDTO);
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
