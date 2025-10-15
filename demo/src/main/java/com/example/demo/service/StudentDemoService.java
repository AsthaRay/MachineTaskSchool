package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDemoService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDto addStudent(StudentDto studentDto) {
        //Create new DB entity object
        Student student = new Student();
        //Set name in new entity object from studentDto
        student.setName(studentDto.getName());
        //Set email in new entity object from studentDto
        student.setEmail(studentDto.getEmail());
        //Set marks in new entity object from studentDto
        student.setMarks(studentDto.getMarks());

        //Save newly created record into db and get saved record
        Student savedStudent = studentRepository.save(student);

        //Create new Dto for response
        StudentDto responseDto = new StudentDto();
        //Set generated id in response dto object from saved record
        responseDto.setId(savedStudent.getId());
        //Set generated name in response dto object from saved record
        responseDto.setName(savedStudent.getName());
        //Set generated email in response dto object from saved record
        responseDto.setEmail(savedStudent.getEmail());
        //Set generated marks in response dto object from saved record
        responseDto.setMarks(savedStudent.getMarks());

        return responseDto;
    }

    public List<StudentDto> getStudentWithMarks(Integer marks) {
        List<Student> fetchedRecord = studentRepository.findAll();
        List<StudentDto> responseList = new ArrayList<>();

        for(int i=0; i<fetchedRecord.size(); i++){
            Student studentEntity = new Student();
            StudentDto studentDto = new StudentDto();

            studentEntity.setId(studentDto.getId());
            studentEntity.setName(studentDto.getName());
            studentEntity.setEmail(studentDto.getEmail());
            studentEntity.setMarks(studentDto.getMarks());

            responseList.add(studentDto);
        }
        return responseList;
    }

    public List<StudentDto> getStudentAll() {
        List<Student> fetchedRecord = studentRepository.findAll();
        List<StudentDto> responseList = new ArrayList<>();

        for(int i=0; i<fetchedRecord.size(); i++){
            Student studentEntity = fetchedRecord.get(i);
            StudentDto studentDto = new StudentDto();

            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setEmail(studentEntity.getEmail());
            studentDto.setMarks(studentEntity.getMarks());

            responseList.add(studentDto);
        }
        return responseList;
    }

    public List<StudentDto> addAllStudents(List<StudentDto> students) {
        List<Student> fetchedRecord = studentRepository.findAll();
        List<StudentDto> responseList = new ArrayList<>();

        for(int i=0; i<fetchedRecord.size(); i++){
            Student studentEntity = fetchedRecord.get(i);
            StudentDto studentDto = new StudentDto();

            studentDto.setId(studentEntity.getId());
            studentDto.setName(studentEntity.getName());
            studentDto.setEmail(studentEntity.getEmail());
            studentDto.setMarks(studentEntity.getMarks());

            responseList.add(studentDto);
        }
        return responseList;
    }
}