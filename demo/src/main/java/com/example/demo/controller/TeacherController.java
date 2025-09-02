package com.example.demo.controller;

import com.example.demo.dto.GenericResponseDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.exceptions.GenericException;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping("/createTeacher")
    public GenericResponseDto<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Teacher created successfully");
        response.setMeta(teacherService.createTeacher(teacherDto));
        return response;
    }

    @PutMapping("/{id}")
    public GenericResponseDto<TeacherDto> updateTeacher(@PathVariable Long id,@RequestBody TeacherDto teacherDto){
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Teacher updated successfully");
        response.setMeta(teacherService.updateTeacher(id, teacherDto));
        return response;
    }

    @GetMapping("/{id}")
    public GenericResponseDto<TeacherDto> getTeacherById(@PathVariable Long id){
        GenericResponseDto<TeacherDto> response = new GenericResponseDto<>();
        response.setError(false);
        response.setMessage("Fetched teacher successfully");
        response.setMeta(teacherService.getTeacherById(id));
        return response;
    }

}
