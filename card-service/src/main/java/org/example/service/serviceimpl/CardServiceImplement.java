package org.example.service.serviceimpl;

import org.example.model.Card;
import org.example.model.request.CardRequest;
import org.example.repository.CardRepository;
import org.example.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImplement implements CardService {
    private final CardRepository cardRepository;

    public CardServiceImplement(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow();
    }

    @Override
    public Card createCard(CardRequest cardRequest) {
        Card card = new Card();
        card.setStudentId(cardRequest.getStudentId());
        card.setCardDetail(cardRequest.getCardDetail());
        card.setCardCode(cardRequest.getCardCode());
        return cardRepository.save(card);
    }

    @Override
    public Card getCardByStudentId(Long studentId) {
        return cardRepository.findCardByStudentId(studentId);
    }

    @Override
    public void deleteCardByStudentId(Long studentId) {
        cardRepository.deleteCardByStudentId(studentId);
    }

    @Override
    public Card updateCardByStudentId(CardRequest cardRequest) {
        Card card = cardRepository.findCardByStudentId(cardRequest.getStudentId());
        card.setCardCode(cardRequest.getCardCode());
        card.setCardDetail(card.getCardDetail());
        return cardRepository.save(card);
    }
}
