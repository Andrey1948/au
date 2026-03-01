package com.example.andreuapp.service;

import com.example.andreuapp.entity.Group;
import com.example.andreuapp.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Group getGroupById(int id) {
       return groupRepository.findById(id).get();
    }

    public Group save(Group group) {
       return groupRepository.save(group);
       }

//    public Integer getCOuntStudentByGroup(Group group) {
//       return groupRepository.countStudentByGroup(group);
//    }

    }

