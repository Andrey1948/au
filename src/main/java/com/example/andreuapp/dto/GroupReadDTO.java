package com.example.andreuapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;


@AllArgsConstructor
@Builder
public class GroupReadDTO {

    private Long id;
    private String number;

    public GroupReadDTO() {
    }

    public String getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }
}
