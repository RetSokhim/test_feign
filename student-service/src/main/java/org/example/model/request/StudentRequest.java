package org.example.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private Integer studentAge;
    private String phoneNumber;
    private Integer cardCode;
    private String cardDetail;
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCardCode() {
        return cardCode;
    }

    public void setCardCode(Integer cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardDetail() {
        return cardDetail;
    }

    public void setCardDetail(String cardDetail) {
        this.cardDetail = cardDetail;
    }
}
