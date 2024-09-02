package org.example.controller;

import org.example.model.Card;
import org.example.model.request.CardRequest;
import org.example.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("get-card/{cardId}")
    public Card getCardById(@PathVariable Long cardId){
        return cardService.getCardbyId(cardId);
    }

    @PostMapping("create-card")
    public Card createCard (@RequestBody CardRequest cardRequest){
        return cardService.createCard(cardRequest);
    }
}
