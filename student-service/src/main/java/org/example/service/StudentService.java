package org.example.service;

import org.example.model.Student;
import org.example.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long studentId);
    Student createStudent(StudentRequest studentRequest);
    List<Student> getAllStudent();
    void deleteStudentById(Long studentId);
    Student updateStudentById(Long studentId, StudentRequest studentRequest);
}
