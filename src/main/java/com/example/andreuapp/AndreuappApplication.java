package com.example.andreuapp;


import com.example.andreuapp.entity.Group;
import com.example.andreuapp.repository.GroupRepository;
import com.example.andreuapp.service.GroupService;
import com.example.andreuapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AndreuappApplication {


    public static void main(String[] args) {
        SpringApplication.run(AndreuappApplication.class, args);
    }

    @Bean
    public CommandLineRunner test(GroupService groupService) {
        return args -> {
            System.out.println("Проверка сервиса при старте:");
            groupService.getGroups();
        };
    }

    @Bean
    public CommandLineRunner testQuery(GroupRepository repository) {
        return args -> {
            Group g = repository.findByNumberFromQuery("20-02");
            System.out.println(g);
        };
    }

//    @Bean
//    public CommandLineRunner testQuery3(StudentService studentService, GroupRepository groupRepository) {
//        return args -> {
//            Group group = groupRepository.findByNumberFromQuery("20-02");
//            Student student = new Student();
//            student.setGroup(group);
//            student.setFullName("Kirill Ivanov");
//            student.setDateOfEnrollment(LocalDate.of(2022, 03, 01));
//            studentService.save(student);
//        };
//    }

    @Bean
    public CommandLineRunner testQuery4(StudentService studentService, GroupRepository groupRepository) {
        return args -> {
            Long studentId = 15L;
            String groupNumber = "20-02";
            studentService.updateStudentGroup(studentId, groupNumber );

        };
    }

    }
