package org.example.model.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CardRequest {
    private Integer cardCode;
    private String cardDetail;

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
