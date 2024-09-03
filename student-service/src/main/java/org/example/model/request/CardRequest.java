package org.example.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CardRequest {
    private Integer cardCode;
    private String cardDetail;
    private Long studentId;


//    public Integer getCardCode() {
//        return cardCode;
//    }
//
//    public void setCardCode(Integer cardCode) {
//        this.cardCode = cardCode;
//    }
//
//    public String getCardDetail() {
//        return cardDetail;
//    }
//
//    public void setCardDetail(String cardDetail) {
//        this.cardDetail = cardDetail;
//    }
}
