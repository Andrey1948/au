package com.example.andreuapp.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_enrollment")
    private LocalDate dateOfEnrollment;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;





    public Long getId() {
        return id;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }
    public String getFullName() {
        return fullName;
    }

    public Group getGroup() {
        return group;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
