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
        try {
            Student studentEntity = StudentDtoFormatter.toStudentEntity(studentRequestDto);
            Student savedStudent = studentRepository.save(studentEntity);
            StudentDto studentResponseDto = StudentDtoFormatter.toStudentDto(savedStudent);
            return studentResponseDto;

        } catch (Exception e) {
            throw new GenericException("Unable to save student");
        }
    }

    public StudentDto updateStudent(StudentDto studentRequestDto) {
        Student existingStudentEntity = studentRepository.findById(studentRequestDto.getId())
                .orElseThrow(() -> new GenericException("Student not found with id: " + studentRequestDto.getId()));
        existingStudentEntity.setCourses(existingStudentEntity.getCourses());
        existingStudentEntity.setId(existingStudentEntity.getId());
       if(!studentRequestDto.getName().isEmpty()){
           existingStudentEntity.setName(existingStudentEntity.getName());
       } else if (!studentRequestDto.getEmail().isEmpty()) {
           existingStudentEntity.setEmail(existingStudentEntity.getEmail());
       }
        Student updatedStudent = studentRepository.save(existingStudentEntity);
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
