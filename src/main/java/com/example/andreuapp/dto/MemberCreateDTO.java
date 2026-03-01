package com.example.andreuapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class MemberCreateDTO {
    private String name;
    private int age;
    private String secretIdentity;
    List<String> powers;

    public MemberCreateDTO() {
    }


}
