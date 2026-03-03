package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.GroupReadDTO;
import com.example.andreuapp.entity.Group;

import com.example.andreuapp.mapper.GroupReadDtoMapper;
import com.example.andreuapp.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupReadDtoMapper groupReadDtoMapper;

    public GroupService(GroupRepository groupRepository, GroupReadDtoMapper groupReadDtoMapper) {
        this.groupRepository = groupRepository;
        this.groupReadDtoMapper = groupReadDtoMapper;
    }

    public List<Group> getGroups() {
        System.out.println(groupRepository.findAll());
        return groupRepository.findAll();

    }

    @Transactional
    public GroupReadDTO getGroupById(Integer id) {
        return groupRepository.findById(id).map(u-> groupReadDtoMapper.toDto(u)).orElseThrow();
    }


    @Transactional
    public Group save(Group group) {
        return groupRepository.save(group);
    }




}

