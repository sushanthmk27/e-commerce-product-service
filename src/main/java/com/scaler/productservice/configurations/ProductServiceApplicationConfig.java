package com.scaler.productservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//This is a Spring configuration class
// We can also use @Component if we are not sure of the annotation to be used for the class.
// @Component is like a super annotation
@Configuration
public class ProductServiceApplicationConfig {

    // Here we create a bean(object) for RestTemplate so that it can be called and used at any class.
    // This is a good practice to prevent numerous object creation in the class for the same.
    // Spring framework should call this method and stor the bean in the Spring Container
    // It is mandatory to write @Bean else Springfw wont create a bean of RestTemplate and we wont be able to use the object of RestTemplate at any other class
    @Bean
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }


}
