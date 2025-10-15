package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;

    public AuthController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDto request) {
        // Normally you'd validate username/password from DB

        UserResponseDto userResponseDto = userService.getUserByEmailAndPassword(request);
        if (userResponseDto != null) {
            String token = jwtTokenUtil.generateToken(userResponseDto.getEmail());
            return Map.of("token", token);
        } else {
            return Map.of("error", "Invalid credentials");
        }
    }
}