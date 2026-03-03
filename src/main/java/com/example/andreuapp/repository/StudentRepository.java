package com.example.andreuapp.repository;

import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByFullName(String fullName);



    @Query("SELECT g.number as groupNum, COUNT(s) as studentsCount " +
            "FROM Group g full JOIN g.students s GROUP BY g.number")
    List<GroupCountDto> countStudentByGroupName();



}
