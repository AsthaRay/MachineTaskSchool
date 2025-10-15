package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/studentDemo")
public class StudentControllerDemo {

    @Autowired
    StudentDemoService service;

    @PostMapping()
    public StudentDto addStudent(@RequestBody StudentDto studentDto){
        return service.addStudent(studentDto);
    }

    @PostMapping("/addStudentModified")
    public StudentDto addStudentModified(@RequestBody StudentDto studentDto){
        String modifiedName = studentDto.getName() + " - MODIFIED";
        studentDto.setName(modifiedName);
        return service.addStudent(studentDto);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        return service.getStudentAll();
    }

}
