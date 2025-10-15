package com.example.demo.dtoFormatter;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.User;

public class UserDtoFormatter {
    public static UserDto toUserDto(User userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setActive(userEntity.isActive());
        return userDto;
    }

    public static UserResponseDto toUserResponseDto(User userEntity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(userEntity.getId());
        userResponseDto.setEmail(userEntity.getEmail());
        userResponseDto.setActive(userEntity.isActive());
        return userResponseDto;
    }

    public static User toUserEntity(UserDto userDto) {
        User userEntity = new User();
        userEntity.setId(userDto.getId());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setActive(userDto.isActive());
        return userEntity;
    }
}
