package com.example.demo.dto;

import com.example.demo.model.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private List<CourseDto> courses = new ArrayList<>();
}
