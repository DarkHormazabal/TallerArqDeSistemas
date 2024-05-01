package org.example.Interfaces;

import org.example.Models.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public interface ICardRepository {

    /**
     * @param card to add
     * @return
     */
    public Card addCard(Card card);

    /**
     * @return
     * show cards in general
     */
    public List<Card> getCards();

    /**
     * @return
     * @param id to view
     */
    public List<Card> getCardsByPreccense(int preccense);

    /**
     * @return
     * @param id to view
     */
    public List<Card> getCardsById(int id);

}
