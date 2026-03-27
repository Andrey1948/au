package com.example.andreuapp.controller;

import com.example.andreuapp.dto.GroupEditDto;

import com.example.andreuapp.mapper.GroupMapper;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;

import org.openapitools.api.GroupsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.openapitools.model.GroupReadDto;


import java.util.List;

@RestController
//@RequestMapping("/v1/groups")
public class GroupController implements GroupsApi {

    private final GroupService groupService;
    private final GroupMapper groupMapper;


    public GroupController(GroupService groupService, StudentService studentService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @Override
    public ResponseEntity<List<org.openapitools.model.GroupReadDto>> findAllGroups() {
        return ResponseEntity.ok(groupService.findAll().stream().map(s -> groupMapper.toApi(s))
                .toList());
    }


    @Override
    public ResponseEntity<org.openapitools.model.GroupReadDto> findGroupById(@PathVariable Integer id) {
        return  ResponseEntity.ok(groupMapper.toApi(groupService.findById(id)));

    }

    @Override
    public ResponseEntity<org.openapitools.model.GroupReadDto> createOrUpdateGroup(@RequestBody org.openapitools.model.GroupEditDto groupEditDto) {
        return ResponseEntity.ok(
                groupMapper.toApi(
                        groupService.save(
                                groupMapper.toGroupEditFromApi(groupEditDto))));
    }

    @Override
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
       groupService.delete(id);
       return ResponseEntity.noContent().build();
    }


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



