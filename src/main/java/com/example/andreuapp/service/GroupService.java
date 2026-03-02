package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupReadDTO;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() {
        System.out.println(groupRepository.findAll());
        return groupRepository.findAll();

    }

    @Transactional
    public Group getGroupById(int id) {
        return groupRepository.findById(id).orElseThrow(()-> new RuntimeException("Error"));
    }

    @Transactional
    public Group save(Group group) {
        return groupRepository.save(group);
    }

//       public GroupEd

//    public Integer getCOuntStudentByGroup(Group group) {
//       return groupRepository.countStudentByGroup(group);
//    }

}

