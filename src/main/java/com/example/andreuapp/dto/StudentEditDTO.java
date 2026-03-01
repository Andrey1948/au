package com.example.andreuapp.dto;


import com.example.andreuapp.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEditDTO {

    private Long id;
    private LocalDate dateOfEnrollment;
    private String fullName;
    private Group group;

}
