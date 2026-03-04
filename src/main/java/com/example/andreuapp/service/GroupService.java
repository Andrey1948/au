package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupEditDto;
import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.entity.Group;

import com.example.andreuapp.entity.Student;
import com.example.andreuapp.mapper.GroupEditDtoMapper;
import com.example.andreuapp.mapper.GroupReadDtoMapper;
import com.example.andreuapp.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupReadDtoMapper groupReadDtoMapper;
    private final GroupEditDtoMapper groupEditDtoMapper;

    public GroupService(GroupRepository groupRepository, GroupReadDtoMapper groupReadDtoMapper, GroupEditDtoMapper groupEditDtoMapper) {
        this.groupRepository = groupRepository;
        this.groupReadDtoMapper = groupReadDtoMapper;
        this.groupEditDtoMapper = groupEditDtoMapper;
    }

    public List<GroupReadDto> getAllGroups() {
        return groupRepository.findAll().stream().map(s -> groupReadDtoMapper.toDto(s))
                .toList();
    }

    public GroupReadDto getGroupById(Integer id) {
        return groupRepository.findById(id).map(u -> groupReadDtoMapper.toDto(u)).orElseThrow();
    }

    @Transactional
    public GroupReadDto save(GroupEditDto groupEditDto) {
        Group group = groupEditDtoMapper.toGroup(groupEditDto);
        Group saveGroup = groupRepository.save(group);
        return groupReadDtoMapper.toDto(saveGroup);
    }


    @Transactional
    public boolean delete(Integer id) {
        return groupRepository.findById(id).map(g -> {
                    g.getStudents().
                            forEach(student -> student.setGroup(null));
                    groupRepository.delete(g);
                    return true;
                }).orElse(false);
    }
}

