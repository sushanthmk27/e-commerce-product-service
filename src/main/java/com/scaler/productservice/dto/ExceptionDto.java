package com.scaler.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String errorCode;

    private String errorMessage;

    private String resolution;
}
