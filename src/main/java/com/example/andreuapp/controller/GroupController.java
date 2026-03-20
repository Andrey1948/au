package com.example.andreuapp.controller;

//import com.example.andreuapp.dto.GroupEditDto;

import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.openapitools.api.V1Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.openapitools.model.GroupReadDto;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/v1/groups")
public class GroupController implements V1Api {

    private final GroupService groupService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
    }

    @Override
    public ResponseEntity<List<org.openapitools.model.GroupReadDto>> findAllGroups() {
        return ResponseEntity.ok(groupService.findAll());
    }

//    @GetMapping("/{id}")
//    public Optional<GroupReadDto> findGroupById(@PathVariable Integer id) {
//        return groupService.findById(id);
//
//    }
//
//    @PostMapping()
//    public GroupReadDto createOrUpdateGroup(@RequestBody GroupEditDto groupEditDto) {
//        return groupService.save(groupEditDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean deleteGroup (@PathVariable Integer id) {
//        return groupService.delete(id);
//    }



//    @GetMapping()
//    public List<GroupReadDto> findAllGroups() {
//        return groupService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<GroupReadDto> findGroupById(@PathVariable Integer id) {
//        return groupService.findById(id);
//
//    }
//
//    @PostMapping()
//    public GroupReadDto createOrUpdateGroup(@RequestBody GroupEditDto groupEditDto) {
//        return groupService.save(groupEditDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean deleteGroup (@PathVariable Integer id) {
//       return groupService.delete(id);
//    }

//    @PostMapping("/io")
//    public GroupEditDto test(@RequestBody(required = false) GroupEditDto groupEditDTO) {
//        return new GroupEditDto();
//    }
}



