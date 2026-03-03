package com.example.andreuapp.dto;

import java.util.List;




public class GroupReadDto {

    private Integer id;
    private String number;
    private List<StudentReadDto> students;


    public GroupReadDto(Integer id, String number, List<StudentReadDto> students) {
        this.id = id;
        this.number = number;
        this.students = students;
    }

    public List<StudentReadDto> getStudents() {
        return students;
    }

    public String getNumber() {
        return number;
    }

    public Integer getId() {
        return id;
    }
}
