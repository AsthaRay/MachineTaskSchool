package com.example.demo.dtoFormatter;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.Course;

public class CourseDtoFormatter {
    public static CourseDto toCourseDto(Course courseEntity){
        CourseDto courseDto = new CourseDto();
        courseDto.setId(courseEntity.getId());
        courseDto.setTitle(courseEntity.getTitle());
        courseDto.setDescription(courseEntity.getDescription());
        return courseDto;
    }

    public static Course toCourseEntity(CourseDto courseDto){
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        return course;
    }
}
