package com.example.andreuapp.service;

import com.example.andreuapp.dto.StudentReadDTO;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
import com.example.andreuapp.repository.GroupRepository;
import com.example.andreuapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }


    public List<Student> getStudents() {
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();

    }
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudentGroup(Long id, String number) {
        Student student = studentRepository.findById(id).orElseThrow(NullPointerException::new);
        Group group = (Group) groupRepository.findByNumber(number).orElseThrow(NullPointerException::new);;
        student.setGroup(group);
        studentRepository.save(student);

    }

//    @Transactional
//    public Optional <StudentReadDTO> updateStudentGroup2(Long id, String number) {
//
//    }

}


