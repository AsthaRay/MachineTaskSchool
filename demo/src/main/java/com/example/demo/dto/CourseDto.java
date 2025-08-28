package com.example.demo.dto;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;

    @JsonIgnoreProperties("courses")
    private TeacherDto teacher;

    @JsonIgnore
    private List<StudentDto> students = new ArrayList<>();
}
