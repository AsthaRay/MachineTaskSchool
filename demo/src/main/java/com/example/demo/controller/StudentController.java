package com.example.demo.controller;

import com.example.demo.dto.GenericResponseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.exceptions.GenericException;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public GenericResponseDto<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        GenericResponseDto<StudentDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Student created successfully");
        response.setMeta(studentService.createStudent(studentDto));
        return response;
    }

    @PutMapping("/{id}")
    public GenericResponseDto<StudentDto> updateStudent(@PathVariable Long id,
                                                        @RequestBody StudentDto studentDto) {
        GenericResponseDto<StudentDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Student updated successfully");
        response.setMeta(studentService.updateStudent(id, studentDto));
        return response;
    }

    @GetMapping("/getStudentById/{id}")
    public GenericResponseDto<StudentDto> getStudentById(@PathVariable Long id) throws GenericException {
        GenericResponseDto<StudentDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Fetched student successfully");
        response.setMeta(studentService.getStudentById(id));
        return response;
    }


}
