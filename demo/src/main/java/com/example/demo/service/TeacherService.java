package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import com.example.demo.exceptions.GenericException;
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


    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDto.getName());
        teacher.setEmail(teacherDto.getEmail());
        Teacher savedTeacher = teacherRepository.save(teacher);
        return mapToDto(savedTeacher);
    }


    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) throws GenericException {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericException("Teacher not found with id: " + id));
        teacher.setName(teacherDto.getName());
        teacher.setEmail(teacherDto.getEmail());
        Teacher updatedTeacher = teacherRepository.save(teacher);
        return mapToDto(updatedTeacher);
    }


    public TeacherDto getTeacherById(Long id) throws GenericException {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new GenericException("Teacher not found with id: " + id));
        return mapToDto(teacher);
    }


    private TeacherDto mapToDto(Teacher teacher) {
        TeacherDto dto = new TeacherDto();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        return dto;
    }

}
