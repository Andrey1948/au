package com.example.andreuapp;


import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
import com.example.andreuapp.repository.GroupRepository;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AndreuappApplication {


    public static void main(String[] args) {
        SpringApplication.run(AndreuappApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner testQuery(GroupRepository repository) {
//        return args -> {
//            Group g = repository.findByNumberFromQuery("20-02");
//            System.out.println(g);
//        };
//    }

//    @Bean
//    public CommandLineRunner testQuery4(StudentService studentService, GroupRepository groupRepository) {
//        return args -> {
//            Long studentId = 2L;
//            String groupNumber = "20-01";
//            StudentUpdateGroupDto sugdto = new StudentUpdateGroupDto(studentId,groupNumber);
//            studentService.updateStudentGroup(sugdto);
//
//        };
//    }

    }
