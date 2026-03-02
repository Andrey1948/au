package com.example.andreuapp.dto;

import com.example.andreuapp.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupEditDTO {

    private Integer id;
    private String number;
    private List<Student> students;
}
