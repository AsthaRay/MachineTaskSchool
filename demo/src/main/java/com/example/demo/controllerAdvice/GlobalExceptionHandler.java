package com.example.demo.controllerAdvice;

import com.example.demo.dto.GenericResponseDto;
import com.example.demo.exceptions.GenericException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public GenericResponseDto<Object> handleProductNotFoundException(GenericException ex) {
        GenericResponseDto<Object> exceptionDto = new GenericResponseDto<>();
        exceptionDto.setError(true);
        exceptionDto.setMessage(ex.getLocalizedMessage());
        return exceptionDto;
    }
}
