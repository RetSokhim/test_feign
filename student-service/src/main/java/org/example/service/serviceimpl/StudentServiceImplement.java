package org.example.service.serviceimpl;

import org.example.feign.CardServiceFeignClient;
import org.example.model.Student;
import org.example.model.request.CardRequest;
import org.example.model.request.StudentRequest;
import org.example.model.response.CardResponse;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement implements StudentService {
    private final StudentRepository studentRepository;
    private final CardServiceFeignClient cardServiceFeignClient;

    public StudentServiceImplement(StudentRepository studentRepository, CardServiceFeignClient cardServiceFeignClient) {
        this.studentRepository = studentRepository;
        this.cardServiceFeignClient = cardServiceFeignClient;
    }

    @Override
    public Student getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));
            CardResponse card = cardServiceFeignClient.getCardById(studentId);
            student.setCard(card);
        return student;
    }


    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        CardRequest card = new CardRequest();
        student.setStudentAge(studentRequest.getStudentAge());
        student.setStudentName(studentRequest.getStudentName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        Student studentResponse = studentRepository.save(student);
        card.setStudentId(studentResponse.getStudentId());
        card.setCardCode(studentRequest.getCardCode());
        card.setCardDetail(studentRequest.getCardDetail());
        CardResponse cardResponse = cardServiceFeignClient.createCardById(card);
        studentResponse.setCard(cardResponse);
        return studentResponse;
    }
}
