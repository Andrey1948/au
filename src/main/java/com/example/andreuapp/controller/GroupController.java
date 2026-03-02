package com.example.andreuapp.controller;

import com.example.andreuapp.dto.GroupEditDTO;
import com.example.andreuapp.dto.GroupReadDTO;
import com.example.andreuapp.dto.SuperheroCreateDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class GroupController {


    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("{id}")
    public GroupReadDTO getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);

    }

    @PostMapping("/s")
    public Group testSave(@RequestBody Group group) {
        groupService.save(group);
        return group;
    }

    @PostMapping()
    public Group testSave2(@RequestBody(required = false) Group group) {
        return new Group();
    }


    @PostMapping("/io")
    public GroupEditDTO ter(@RequestBody(required = false) GroupEditDTO groupEditDTO) {

        return new GroupEditDTO();
    }
}



