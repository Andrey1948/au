package com.example.andreuapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "number='" + number + '\'' +
                ", id=" + id +
                '}';
    }
}
