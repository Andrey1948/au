package com.example.andreuapp.repository;

import com.example.andreuapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> id(Long id);

    Optional<Student> findByFullName(String fullName);


//
//    @Query("SELECT g.number as number_group, COUNT(s.group_id) AS students_count\n FROM students s\n" +
//            "RIGHT JOIN public.groups g on g.id = s.group_id\n" +
//            "GROUP BY g.number;", nativeQuery = true)
//    public  countStudentByGroupName();


}
