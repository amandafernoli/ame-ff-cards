package com.fastfoward.cardsapi.controller;

import com.fastfoward.cardsapi.model.Card;
import com.fastfoward.cardsapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;
    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("{id}")
    public Card findCardById(@PathVariable("id") int id) {
        LOG.info("Buscando card com Id {}", id);

        var card = cardService.findById(id);

        if(card.isPresent()) {
            return card.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found");

    }
}
