package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupReadDTO;
import com.example.andreuapp.dto.StudentReadDTO;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupReadDtoMapper {

    public GroupReadDTO toDto(Group group) {
        if (group == null) {
            return null;
        }
        List<StudentReadDTO> studentDto = group.getStudents().stream()
                .map(s -> new StudentReadDTO(s.getId(), s.getFullName(), s.getDateOfEnrollment()))
                .toList();
        GroupReadDTO groupReadDTO = new GroupReadDTO(
                group.getId(), group.getNumber(), studentDto);
        return groupReadDTO;

    }

}
