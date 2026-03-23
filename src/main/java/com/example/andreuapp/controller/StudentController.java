package com.example.andreuapp.controller;


import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.mapper.GroupMapper;
import com.example.andreuapp.service.StudentService;
import org.openapitools.api.V1Api;
import org.openapitools.model.GroupReadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/v1/students")
public class StudentController implements V1Api {

    private final StudentService studentService;
    private final GroupMapper groupMapper;

    public StudentController(StudentService studentService, GroupMapper groupMapper) {
        this.studentService = studentService;
        this.groupMapper = groupMapper;
    }

//    @GetMapping()
ResponseEntity<List<GroupCountDto>> findAllQuantity() {
       return ResponseEntity.ok(groupMapper.toApiFromCount(studentService.countStudentByGroupName());
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

//private final StudentService studentService;
//
//public StudentController(StudentService studentService) {
//    this.studentService = studentService;
//}
//
//@GetMapping()
//List<GroupCountDto> findAllQuantity() {
//    return studentService.countStudentByGroupName();
//}
//
//@PostMapping
//public StudentReadDto AddOrUpdatetoGroupStudent(@RequestBody StudentUpdateGroupDto studentUpdateGroupDto) {
//    return studentService.updateStudentGroup(studentUpdateGroupDto);
//}
//
//@DeleteMapping("/{id}")
//public void delete(@PathVariable Long id){
//    studentService.deleteStudent(id);
//}