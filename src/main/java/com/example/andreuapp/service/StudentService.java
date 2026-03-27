package com.example.andreuapp.service;

import com.example.andreuapp.dto.GroupCountDto;
import com.example.andreuapp.dto.StudentReadDto;
import com.example.andreuapp.dto.StudentUpdateGroupDto;
import com.example.andreuapp.entity.Group;
import com.example.andreuapp.entity.Student;
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
    private final StudentReadDtoMapper studentReadDtoMapper;

    StudentService(StudentRepository studentRepository,
                   GroupRepository groupRepository,
                   StudentReadDtoMapper studentReadDtoMapper) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.studentReadDtoMapper = studentReadDtoMapper;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public StudentReadDto updateStudentGroup(StudentUpdateGroupDto updateDto) {
        Student student = studentRepository.findById(updateDto.id()).
                orElseThrow(() -> new MyException("not found student"));
        Group group = groupRepository.findByNumber(updateDto.number()).orElseThrow(() -> new MyException("not found group"));
        group.addStudentToGroup(student);
        return studentReadDtoMapper.toDto(student);
    }

    public List<GroupCountDto> countStudentByGroupName() {
        return studentRepository.countStudentByGroupName();
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new MyException("Student "+id +" not found"));
        studentRepository.delete(student);
    }
}

