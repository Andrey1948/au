package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.entity.Group;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupReadDtoMapper {

    public GroupReadDto toDto(Group group) {
        if (group == null) {
            return null;
        }
        List<StudentReadDto> studentDto = group.getStudents().stream()
                .map(s -> new StudentReadDto(s.getId(), s.getFullName(), s.getDateOfEnrollment()))
                .toList();
        GroupReadDto groupReadDTO = new GroupReadDto(
                group.getId(), group.getNumber(), studentDto);
        return groupReadDTO;

    }

}
