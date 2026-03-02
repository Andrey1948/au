package com.example.andreuapp.dto;


import com.example.andreuapp.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
public record StudentReadDTO(Long id, String fullName, LocalDate dateOfEnrollment) {





}
