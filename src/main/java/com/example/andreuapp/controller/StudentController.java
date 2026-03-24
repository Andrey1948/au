package com.example.andreuapp.controller;


import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.mapper.GroupMapper;
import com.example.andreuapp.mapper.StudentMapper;
import com.example.andreuapp.service.StudentService;
import org.openapitools.api.StudentsApi;
import org.openapitools.model.GroupReadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/v1/students")
public class StudentController implements StudentsApi {

    private final StudentService studentService;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, GroupMapper groupMapper, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.groupMapper = groupMapper;
        this.studentMapper = studentMapper;
    }

    //    @GetMapping()
    @Override
    public ResponseEntity<List<org.openapitools.model.GroupCountDto>> findAllQuantity() {
        return ResponseEntity.ok(studentService.countStudentByGroupName().stream().map(s ->
                groupMapper.toApiFromCount(s)).toList());
    }


    @Override
    public ResponseEntity<org.openapitools.model.StudentReadDto> addOrUpdatetoGroupStudent(@RequestBody org.openapitools.model.StudentUpdateGroupDto studentUpdateGroupDto) {
        return ResponseEntity.ok(
               studentMapper.toApi(
                        studentService.updateStudentGroup(
                                studentMapper.toUpdateGroupDto(studentUpdateGroupDto))));
    }


//    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Boolean> delete(Long id) {
       return ResponseEntity.ok(studentService.deleteStudent(id));

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