package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String email;
    private String password;
    private boolean isActive = true;
}
