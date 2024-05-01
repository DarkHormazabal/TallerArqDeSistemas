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
     * @param preccenseID to view
     * show cards by preccenseID
     */
    public List<Card> getCardsByPreccense(long preccenseID);

    /**
     * @return
     * @param id to view
     * show cards by id
     */
    public List<Card> getCardsById(long id);

}
