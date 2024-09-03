package org.example.service.serviceimpl;

import org.example.feign.CardServiceFeignClient;
import org.example.model.Student;
import org.example.model.request.CardRequest;
import org.example.model.request.StudentRequest;
import org.example.model.response.CardResponse;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

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
            CardResponse card = cardServiceFeignClient.getCardByStudentId(studentId);
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

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll().
                stream().peek(student -> {
                    CardResponse cardResponse = cardServiceFeignClient.getCardByStudentId(student.getStudentId());
                    student.setCard(cardResponse);
                }).toList();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        cardServiceFeignClient.deleteCardByStudentById(studentId);
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudentById(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        CardRequest cardRequest = new CardRequest();
        cardRequest.setStudentId(studentId);
        cardRequest.setCardCode(studentRequest.getCardCode());
        cardRequest.setCardDetail(studentRequest.getCardDetail());
        CardResponse cardResponse = cardServiceFeignClient.updateCardByStudentId(cardRequest);
        student.setStudentName(studentRequest.getStudentName());
        student.setStudentAge(studentRequest.getStudentAge());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setCard(cardResponse);
        return studentRepository.save(student);
    }
}
