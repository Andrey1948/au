package com.example.andreuapp.controller;

import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/groups")
public class GroupController {

    private final GroupService groupService;
    private final StudentService studentService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public GroupReadDto getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);

    }

    @PostMapping()
    public Group save(@RequestBody Group group) {
        groupService.save(group);
        return group;
    }

//    @PostMapping("/io")
//    public GroupEditDto ter(@RequestBody(required = false) GroupEditDto groupEditDTO) {
//        return new GroupEditDto();
//    }
}



