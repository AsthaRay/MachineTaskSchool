package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.dtoFormatter.CourseDtoFormatter;
import com.example.demo.dtoFormatter.StudentDtoFormatter;
import com.example.demo.dtoFormatter.TeacherDtoFormatter;
import com.example.demo.exceptions.GenericException;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;


    public TeacherDto createTeacher(TeacherDto teacherRequestDto) {
        Teacher teacherEntity = TeacherDtoFormatter.toTeacherEntity(teacherRequestDto);
        Teacher savedTeacher = teacherRepository.save(teacherEntity);
        TeacherDto teacherResponseDto = TeacherDtoFormatter.toTeacherDto(savedTeacher);
        return teacherResponseDto;
    }

    public TeacherDto updateTeacher(Long id, TeacherDto teacherRequestDto) {
        Teacher existingTeacherEntity = teacherRepository.findById(teacherRequestDto.getId())
                .orElseThrow(() -> new GenericException("Student not found with id: " + teacherRequestDto.getId()));
        Teacher teacherEntity = TeacherDtoFormatter.toTeacherEntity(teacherRequestDto);
        teacherEntity.setCourses(existingTeacherEntity.getCourses());
        Teacher updatedTeacher = teacherRepository.save(teacherEntity);
        TeacherDto teacherResponseDto = TeacherDtoFormatter.toTeacherDto(updatedTeacher);
        return teacherResponseDto;
    }

    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericException("Teacher not found with id: " + id));

        TeacherDto teacherResponseDto = TeacherDtoFormatter.toTeacherDto(teacher);
        return teacherResponseDto;
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericException("Teacher not found with id: " + id));
        teacherRepository.delete(teacher);
    }

}
