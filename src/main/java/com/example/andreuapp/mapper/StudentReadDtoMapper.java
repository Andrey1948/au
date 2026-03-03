package com.example.andreuapp.mapper;


import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentReadDtoMapper {


    public StudentReadDto toStudent(Student student) {
        if (student == null){return null;}
        StudentReadDto stdto = new StudentReadDto(
                student.getId(),student.getFullName(),student.getDateOfEnrollment()
        );
        return stdto;
    }
}
