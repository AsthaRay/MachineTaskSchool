package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.dtoFormatter.CourseDtoFormatter;
import com.example.demo.dtoFormatter.StudentDtoFormatter;
import com.example.demo.exceptions.GenericException;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDto createCourse(CourseDto courseRequestDto){
        Course courseEntity = CourseDtoFormatter.toCourseEntity(courseRequestDto);
        Course savedCourse = courseRepository.save(courseEntity);
        CourseDto courseResponseDto = CourseDtoFormatter.toCourseDto(savedCourse);
        return courseResponseDto;
    }

    public CourseDto updateCourse(Long id,CourseDto courseRequestDto){
        Course existingCourseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new GenericException("Course not found with id: " + id));
        Course courseEntity = CourseDtoFormatter.toCourseEntity(courseRequestDto);
        Course updatedCourse= courseRepository.save(courseEntity);
        CourseDto courseResponseDto = CourseDtoFormatter.toCourseDto(updatedCourse);
        return courseResponseDto;

    }
}
