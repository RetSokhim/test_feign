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
    public Card getCardbyId(Long cardId) {
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
}
