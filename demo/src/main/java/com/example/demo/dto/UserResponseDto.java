package com.example.demo.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private long id;
    private String email;
    private boolean isActive;
}
