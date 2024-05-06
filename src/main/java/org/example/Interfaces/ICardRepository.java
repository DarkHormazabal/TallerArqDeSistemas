package org.example.Interfaces;

import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.Models.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public interface ICardRepository {

    /**
     * @param addEntityCardDTO to add
     * @return
     */
    public Card addEntityCard(AddEntityCardDTO addEntityCardDTO);

    /**
     * @param addSkillCardDTO to add
     * @return
     */
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO);

    /**
     * @param findCard to add
     * @return
     */
    public Card restoreCard(Card findCard);

    /**
     * @param name add
     * @return
     */
    public Card Find(String name);

    /**
     * @param AddCardSeeder add
     * @return
     */


    /**
     * @return
     * show cards in general
     */
    public List<CardDTO> getCards();

    /**
     * @return
     * @param preccenseID to view
     * show cards by preccenseID
     */
    public List<CardDTO> getCardsByPreccense(Long preccenseID);

    /**
     * @return
     * @param id to view
     * show cards by id
     */
    public CardDTO getCardById(Long id);

    /**
     * @return
     * @param id to view
     * change Card's delete
     */
    public boolean deleteCard(Long id);

}
