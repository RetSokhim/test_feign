package org.example.service;

import org.example.model.Card;
import org.example.model.request.CardRequest;

public interface CardService {
    Card getCardbyId(Long cardId);
    Card createCard(CardRequest cardRequest);
}
