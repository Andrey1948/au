package com.example.andreuapp.dto;

import com.example.andreuapp.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@Builder
public class GroupEditDTO {

    private Integer id;
    private String number;


    public GroupEditDTO(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public GroupEditDTO() {
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


