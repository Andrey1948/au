package com.example.andreuapp.dto;


import com.example.andreuapp.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentEditDto {

    private String fullName;
    private Group group;

    public StudentEditDto() {
    }

    public StudentEditDto(String fullName, Group group) {
        this.fullName = fullName;
        this.group = group;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
