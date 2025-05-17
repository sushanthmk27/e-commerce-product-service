package com.scaler.productservice.controlleradvice;

import com.scaler.productservice.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling exceptions in the ProductService application.
 *
 * This class is marked with @ControllerAdvice to enable centralized exception handling
 * across the application. It defines methods to handle specific exceptions and return
 * appropriate HTTP responses.
 */
@ControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setErrorCode("404");
        exceptionDTO.setErrorMessage("Product Not Found");
        exceptionDTO.setResolution("Please check the product ID");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
           /*return ResponseEntity.notFound().build();*/
    }
}
