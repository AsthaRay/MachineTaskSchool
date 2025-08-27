package com.example.demo.dto;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private TeacherDto teacher;
    private List<StudentDto> students = new ArrayList<>();
}
