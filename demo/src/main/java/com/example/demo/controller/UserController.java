package com.example.demo.controller;

import com.example.demo.dto.GenericResponseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public GenericResponseDto<UserResponseDto> createUser(@RequestBody UserDto userDto) {
        GenericResponseDto<UserResponseDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("User created successfully");
        response.setMeta(userService.createUser(userDto));
        return response;
    }


    @PostMapping("/getUserByEmailAndPassword")
    public GenericResponseDto<UserResponseDto> getUserByEmailAndPassword(@RequestBody UserDto userDto) {
        GenericResponseDto<UserResponseDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("User Fetched Successfully");
        response.setMeta(userService.getUserByEmailAndPassword(userDto));
        return response;
    }
}
