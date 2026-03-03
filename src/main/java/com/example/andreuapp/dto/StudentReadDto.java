package com.example.andreuapp.dto;


import lombok.Builder;

import java.time.LocalDate;

@Builder
public record StudentReadDto(Long id, String fullName, LocalDate dateOfEnrollment) {





}
