package com.example.demo.dto;

import com.example.demo.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String email;
    private List<CourseDto> courses = new ArrayList<>();

}
