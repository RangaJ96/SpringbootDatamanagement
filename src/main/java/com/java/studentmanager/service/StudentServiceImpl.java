package com.java.studentmanager.service;

import com.java.studentmanager.domain.Student;
import com.java.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student){

        return studentRepository.save(student);
    }

    @Override
    public Student getById(String studentId) {
        return studentRepository.getOne(studentId);
    }
}
