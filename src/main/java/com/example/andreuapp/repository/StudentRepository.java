package com.example.andreuapp.repository;

import com.example.andreuapp.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {


}
