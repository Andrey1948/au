package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupEditDTO;
import com.example.andreuapp.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupEditDtoMapper {

    public Group toGroup(GroupEditDTO groupEditDTO) {
        if(groupEditDTO == null) return null;
        Group group = new Group();
        group.setId(groupEditDTO.getId());
        group.setNumber(groupEditDTO.getNumber());
        return group;
    }

    public GroupEditDTO toGroupEditDTO(Group group) {
        if(group == null) return null;
        GroupEditDTO groupEditDTO = new GroupEditDTO();
        groupEditDTO.setId(group.getId());
        groupEditDTO.setNumber(group.getNumber());
        return groupEditDTO;
    }
}
