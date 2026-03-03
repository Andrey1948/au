package com.example.andreuapp.controller;


import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/s")
public class StudentController {

    private final GroupService groupService;
    private final StudentService studentService;

    public StudentController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @PostMapping("/z")
    List<GroupCountDto> countStudentByGroupName() {
       return studentService.countStudentByGroupName();
    }
}
