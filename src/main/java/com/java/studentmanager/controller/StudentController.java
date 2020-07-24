package com.java.studentmanager.controller;

import com.java.studentmanager.domain.Student;
import com.java.studentmanager.service.StudentService;
import com.java.studentmanager.service.dto.StudentRequet;
import com.java.studentmanager.service.dto.StudentResponse;
import com.java.studentmanager.service.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create-student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody StudentResponse createStudent(@RequestBody StudentRequet studentRequet){
        Student student = StudentTransformer.createStudentRequestToDomian(studentRequet);
        Student createdStudent = studentService.createStudent(student);
        StudentResponse responseObject = new StudentResponse();
        try{
             responseObject = StudentTransformer.studentDominToResponse(studentService.getById(createdStudent.getId()));

        }catch (Exception e){
            e.printStackTrace();
        }
        return responseObject;
    }
}
