package com.example.demo.dto;

import lombok.Data;

@Data
public class GenericResponseDto<T> {
    private Boolean error;
    private T meta;
    private String message;
}
