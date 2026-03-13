package com.example.andreuapp.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GroupEditDto {

    private Integer id;
    private String number;


    public GroupEditDto(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public GroupEditDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}


