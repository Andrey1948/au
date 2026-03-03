package com.example.andreuapp.dto;


import com.example.andreuapp.entity.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentEditDto {

    private Long id;
    private String fullName;
    private Group group;

    public StudentEditDto() {
    }

    public StudentEditDto(Long id, String fullName, Group group) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
