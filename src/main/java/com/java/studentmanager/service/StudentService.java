package com.java.studentmanager.service;

import com.java.studentmanager.domain.Student;

public interface StudentService {

    Student createStudent(Student student);

    Student getById(String studentId);
}
