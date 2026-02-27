package com.example.andreuapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false, unique = true)
    private String number;


    @OneToMany (mappedBy = "group")
    private List<Student> students;

    public void addStudentsToGroup(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setGroup(this);
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
