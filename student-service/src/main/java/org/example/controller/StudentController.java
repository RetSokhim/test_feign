package org.example.controller;

import org.example.model.Student;
import org.example.model.request.StudentRequest;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("get-all-student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    @DeleteMapping("delete-student/{studentId}")
    public String deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return "Delete student Successfully";
    }

    @PutMapping("update-student/{studentId}")
    public Student updateStudentById(@PathVariable Long studentId,@RequestBody StudentRequest studentRequest){
        return studentService.updateStudentById(studentId,studentRequest);
    }
}
