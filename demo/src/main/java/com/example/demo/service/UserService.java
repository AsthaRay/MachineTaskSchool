package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.dtoFormatter.UserDtoFormatter;
import com.example.demo.exceptions.GenericException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseDto createUser(UserDto userDto) {
        try {
            User userEntity = UserDtoFormatter.toUserEntity(userDto);
            User savedUser = userRepository.save(userEntity);
            return UserDtoFormatter.toUserResponseDto(savedUser);
        } catch (Exception e) {
            throw new GenericException("Unable to save user");
        }
    }

    public UserResponseDto getUserByEmailAndPassword(UserDto userDto) {
        User userEntity = userRepository.getUserByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if(userEntity == null) {
            return null;
        }
        return UserDtoFormatter.toUserResponseDto(userEntity);
    }
}