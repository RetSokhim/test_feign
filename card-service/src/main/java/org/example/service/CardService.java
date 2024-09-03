package org.example.service;

import org.example.model.Card;
import org.example.model.request.CardRequest;

public interface CardService {
    Card getCardById(Long cardId);
    Card createCard(CardRequest cardRequest);
    Card getCardByStudentId(Long studentId);
    void deleteCardByStudentId(Long studentId);
    Card updateCardByStudentId(CardRequest cardRequest);
}
