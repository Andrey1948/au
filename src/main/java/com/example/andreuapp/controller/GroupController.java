package com.example.andreuapp.controller;

import com.example.andreuapp.dto.GroupEditDto;
import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/groups")
public class GroupController {

    private final GroupService groupService;
    private final StudentService studentService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping()
    public List<GroupReadDto> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupReadDto findGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);

    }

    @PostMapping()
    public GroupReadDto createOrUpdateGroup(@RequestBody GroupEditDto groupEditDto) {
        return groupService.save(groupEditDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGroup (@PathVariable Integer id) {
       return groupService.delete(id);
    }

//    @PostMapping("/io")
//    public GroupEditDto test(@RequestBody(required = false) GroupEditDto groupEditDTO) {
//        return new GroupEditDto();
//    }
}



