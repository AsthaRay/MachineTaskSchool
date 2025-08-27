package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dtoFormatter.StudentDtoFormatter;
import com.example.demo.exceptions.GenericException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDto createStudent(StudentDto studentRequestDto) {
        Student studentEntity = StudentDtoFormatter.toStudentEntity(studentRequestDto);
        Student savedStudent = studentRepository.save(studentEntity);
        StudentDto studentResponseDto = StudentDtoFormatter.toStudentDto(savedStudent);
        return studentResponseDto;
    }

    public StudentDto updateStudent(StudentDto studentRequestDto) {
        Student existingStudentEntity = studentRepository.findById(studentRequestDto.getId())
                .orElseThrow(() -> new GenericException("Student not found with id: " + studentRequestDto.getId()));
        Student studentEntity = StudentDtoFormatter.toStudentEntity(studentRequestDto);
        studentEntity.setCourses(existingStudentEntity.getCourses());
        Student updatedStudent = studentRepository.save(studentEntity);
        StudentDto studentResponseDto = StudentDtoFormatter.toStudentDto(updatedStudent);
        return studentResponseDto;
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new GenericException("Student not found with id: " + id));

        StudentDto studentResponseDto = StudentDtoFormatter.toStudentDto(student);
        return studentResponseDto;
    }

     public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new GenericException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

}
