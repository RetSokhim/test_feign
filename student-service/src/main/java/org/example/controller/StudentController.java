package org.example.controller;

import org.example.model.Student;
import org.example.model.request.StudentRequest;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("get-student/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
    @PostMapping("create-student")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }
}
