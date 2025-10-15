package com.example.demo.dto;

import com.example.demo.model.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private Integer marks;
  //  @JsonIgnore
    private List<CourseDto> courses = new ArrayList<>();
}
