package com.example.demo.dtoFormatter;

import com.example.demo.dto.TeacherDto;
import com.example.demo.model.Teacher;

public class TeacherDtoFormatter {
    public static TeacherDto toTeacherDto(Teacher teacherEntity){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacherEntity.getId());
        teacherDto.setName(teacherEntity.getName());
        teacherDto.setEmail(teacherEntity.getEmail());
        return teacherDto;
    }
    public static Teacher toTeacherEntity(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setName(teacherDto.getName());
        teacher.setEmail(teacherDto.getEmail());
        return teacher;
    }
}
