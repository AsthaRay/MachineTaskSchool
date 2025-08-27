package com.example.demo.dtoFormatter;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;

public class StudentDtoFormatter {
    public static StudentDto toStudentDto(Student studentEntity){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setEmail(studentEntity.getEmail());
      //  studentDto.setCourses(student.getCourses());
        return studentDto;
    }

    public static Student toStudentEntity(StudentDto studentDto){
        Student studentEntity = new Student();
        studentEntity.setId(studentDto.getId());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setName(studentDto.getName());
        //studentEntity.setCourses(studentDto.getCourses());
        return studentEntity;
    }
}
