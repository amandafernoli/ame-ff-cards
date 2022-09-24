package com.fastfoward.cardsapi.repository;

import com.fastfoward.cardsapi.model.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(int id);

}
