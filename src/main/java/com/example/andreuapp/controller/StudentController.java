package com.example.andreuapp.controller;


import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/students")
public class StudentController {

    private final GroupService groupService;
    private final StudentService studentService;

    public StudentController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/quantity")
    List<GroupCountDto> countStudentByGroupName() {
       return studentService.countStudentByGroupName();
    }

    @PostMapping
    public StudentReadDto updateGroupStudent(@RequestBody StudentUpdateGroupDto studentUpdateGroupDto) {
        return studentService.updateStudentGroup(studentUpdateGroupDto);
    }

    @GetMapping("/{id}/delete")
    public void delete(@PathVariable Long id){
            studentService.deleteStudent(id);
    }


}
