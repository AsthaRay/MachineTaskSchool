package com.example.demo.controller;

import com.example.demo.dto.GenericResponseDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.exceptions.GenericException;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/create")
    public GenericResponseDto<TeacherDto> createTeacher(@RequestBody TeacherDto dto) throws GenericException {
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Teacher created successfully");
        response.setMeta(teacherService.createTeacher(dto));
        return response;
    }

    @PutMapping("/{id}")
    public GenericResponseDto<TeacherDto> updateTeacher(@PathVariable Long id, @RequestBody TeacherDto dto) throws GenericException {
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Teacher updated successfully");
        response.setMeta(teacherService.updateTeacher(id, dto));
        return response;
    }

    @GetMapping("/{id}")
    public GenericResponseDto<TeacherDto> getTeacher(@PathVariable Long id) throws GenericException {
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Teacher fetched successfully");
        response.setMeta(teacherService.getTeacherById(id));
        return response;
    }

}
