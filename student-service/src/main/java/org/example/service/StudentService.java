package org.example.service;

import org.example.model.Student;
import org.example.model.request.StudentRequest;

public interface StudentService {
    Student getStudentById(Long studentId);
    Student createStudent(StudentRequest studentRequest);
}
