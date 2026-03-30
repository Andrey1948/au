package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupEditDto;
import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.entity.Group;

import com.example.andreuapp.mapper.GroupEditDtoMapper;
import com.example.andreuapp.mapper.GroupReadDtoMapper;
import com.example.andreuapp.repository.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupReadDtoMapper groupReadDtoMapper;
    private final GroupEditDtoMapper groupEditDtoMapper;

    public GroupService(GroupRepository groupRepository, GroupReadDtoMapper groupReadDtoMapper, GroupEditDtoMapper groupEditDtoMapper) {
        this.groupRepository = groupRepository;
        this.groupReadDtoMapper = groupReadDtoMapper;
        this.groupEditDtoMapper = groupEditDtoMapper;
    }

    public List<GroupReadDto> findAll() {
        log.info("Find all Group, return List GRD");
        return groupRepository.findAll().stream().map(s -> groupReadDtoMapper.toDto(s))
                .toList();

    }

    public GroupReadDto findById(Integer id) {
        log.info("find by id method start");
        return groupRepository.findById(id).map(u -> {
                    log.info("Group found successfully {} with", id);
                    return groupReadDtoMapper.toDto(u);
                })
                .orElseThrow(() -> new MyException("id " + id + " not found"));

    }

    @Transactional
    public GroupReadDto save(GroupEditDto groupEditDto) {
        Group group = groupEditDtoMapper.toGroup(groupEditDto);
        Group saveGroup = groupRepository.save(group);
        return groupReadDtoMapper.toDto(saveGroup);
    }


    @Transactional
    public void delete(Integer id) {

        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new MyException("id " + id + " not found"));
        group.getStudents().forEach(student -> student.setGroup(null));
        groupRepository.delete(group);
    }
}

