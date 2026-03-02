package com.example.andreuapp.controller;

import com.example.andreuapp.dto.SuperheroCreateDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/v2")
public class GroupController {


    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/22")
    public Group testSave(@RequestBody Group group) {
        groupService.save(group);
        System.out.println("---");
        return group;
    }

    @PostMapping()
    public Group testSave2(@RequestBody(required = false) Group group) {
        return new Group();
    }
}


