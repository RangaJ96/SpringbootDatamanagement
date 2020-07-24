package com.java.studentmanager.service.transformer;

import com.java.studentmanager.domain.Student;
import com.java.studentmanager.service.dto.StudentRequet;
import com.java.studentmanager.service.dto.StudentResponse;
import org.springframework.beans.BeanUtils;

public class StudentTransformer {

    private StudentTransformer()  {
        throw new RuntimeException("Refelection Attack has been detected");
    }

    public static Student createStudentRequestToDomian(StudentRequet studentRequet){
        Student requestObj = new Student();
        BeanUtils.copyProperties(studentRequet,requestObj);
        return requestObj;
    }

    public static StudentResponse studentDominToResponse(Student student){
        StudentResponse responseObj = new StudentResponse(student.getFirstName(),student.getEmailAddress());
        return responseObj;
    }

}
