package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupEditDto;
import com.example.andreuapp.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GroupEditDtoMapper {

    public Group toGroup(GroupEditDto groupEditDTO) {
        if(groupEditDTO == null) return null;
        Group group = new Group();
        group.setNumber(groupEditDTO.getNumber());
        return group;
    }

    public GroupEditDto toGroupEditDTO(Group group) {
        if(group == null) return null;
        GroupEditDto groupEditDTO = new GroupEditDto();
        groupEditDTO.setNumber(group.getNumber());
        return groupEditDTO;
    }



}
