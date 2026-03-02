package com.example.andreuapp.dto;

import com.example.andreuapp.entity.Student;

import java.util.List;




public class GroupReadDTO {

    private Integer id;
    private String number;
    private List<StudentReadDTO> students;


    public GroupReadDTO(Integer id, String number, List<StudentReadDTO> students) {
        this.id = id;
        this.number = number;
        this.students = students;
    }

    public List<StudentReadDTO> getStudents() {
        return students;
    }

    public String getNumber() {
        return number;
    }

    public Integer getId() {
        return id;
    }
}
