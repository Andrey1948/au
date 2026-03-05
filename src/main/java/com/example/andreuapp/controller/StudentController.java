package com.example.andreuapp.controller;


import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    List<GroupCountDto> findAllQuantity() {
       return studentService.countStudentByGroupName();
    }

    @PostMapping
    public StudentReadDto AddOrUpdatetoGroupStudent(@RequestBody StudentUpdateGroupDto studentUpdateGroupDto) {
        return studentService.updateStudentGroup(studentUpdateGroupDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
            studentService.deleteStudent(id);
    }


}
