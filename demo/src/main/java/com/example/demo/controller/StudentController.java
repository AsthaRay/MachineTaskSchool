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
    public GenericResponseDto<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        GenericResponseDto<StudentDto> genericResponseDto = new GenericResponseDto<>();
        genericResponseDto.setError(false);
        genericResponseDto.setMessage("Student created successfully");
        genericResponseDto.setMeta(studentService.createStudent(studentDto));
        return genericResponseDto;
    }

   /* @PutMapping("/{id}")
    public GenericResponseDto<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        GenericResponseDto<StudentDto> genericResponseDto = new GenericResponseDto<>();

        return studentService.updateStudent(studentDto);
    }*/

    @GetMapping("/getStudentById/{id}")
    public GenericResponseDto<StudentDto> getStudentById(@PathVariable Long id) throws GenericException {
        GenericResponseDto<StudentDto> genericResponseDto = new GenericResponseDto<>();
        genericResponseDto.setError(false);
        genericResponseDto.setMessage("feched student successfully");
        genericResponseDto.setMeta(studentService.getStudentById(id));
        return genericResponseDto;
    }


}
