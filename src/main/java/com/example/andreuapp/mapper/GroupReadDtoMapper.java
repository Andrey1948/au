package com.example.andreuapp.mapper;

import com.example.andreuapp.dto.GroupEditDto;
import com.example.andreuapp.dto.GroupReadDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
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
        return new GroupReadDto(
                group.getId(), group.getNumber(), studentDto);
    }

    public Group toGroup(GroupReadDto dto) {
        if (dto == null) return null;
        Group group = new Group();
        group.setId(dto.getId());
        group.setNumber(dto.getNumber());
        if (dto.getStudents() != null) { List<Student> students = dto.getStudents().stream()
                    .map(sDto -> {
                        Student student = new Student();
                        student.setFullName(sDto.fullName());
                        student.setDateOfEnrollment(sDto.dateOfEnrollment());
                        student.setGroup(group);
                        return student;
                    }).toList();
            group.setStudents(students);
        }

        return group;
    }
}

}
