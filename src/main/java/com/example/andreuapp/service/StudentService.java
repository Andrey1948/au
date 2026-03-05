package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
import com.example.andreuapp.mapper.StudentEditDtoMapper;
import com.example.andreuapp.mapper.StudentReadDtoMapper;
import com.example.andreuapp.repository.GroupRepository;
import com.example.andreuapp.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentEditDtoMapper studentEditDtoMapper;
    private final StudentReadDtoMapper studentReadDtoMapper;

    StudentService(StudentRepository studentRepository, GroupRepository groupRepository,
                   StudentEditDtoMapper studentEditDtoMapper, StudentReadDtoMapper studentReadDtoMapper) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.studentEditDtoMapper = studentEditDtoMapper;
        this.studentReadDtoMapper = studentReadDtoMapper;
    }

    public Optional<Student> findById(Long along) {
        return studentRepository.findById(along);
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
    public StudentReadDto updateStudentGroup(StudentUpdateGroupDto sugd) {
        Student student = studentRepository.findById(sugd.id()).orElseThrow();
        Group group = groupRepository.findByNumber(sugd.number()).orElseThrow();
        student.setGroup(group);
        group.addStudentsToGroup(student);
        return studentReadDtoMapper.toDto(student);
    }

//    public void updateStudentGroup(Long id, String number) {
//        Student student = studentRepository.findById(id).orElseThrow(NullPointerException::new);
//        Group group = (Group) groupRepository.findByNumber(number).orElseThrow(NullPointerException::new);
//        student.setGroup(group);
//        studentRepository.save(student);
//    }

    @Transactional
    public List<GroupCountDto> countStudentByGroupName() {
        return studentRepository.countStudentByGroupName();
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
        }
    }

