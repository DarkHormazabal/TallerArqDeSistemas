package org.example.Interfaces;

import org.example.Models.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public interface ICardRepository {

    /**
     * @param card a agregar
     * @return
     */
    public Card addCard(Card card);

    /**
     * @return
     */
    public List<Card> getCards();

}
