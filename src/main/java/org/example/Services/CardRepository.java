package org.example.Services;

import io.ebean.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.DTO.CardDTO.EntityCardDTO;
import org.example.DTO.CardDTO.SkillCardDTO;
import org.example.Helpers.AutoMapper;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Card;
import org.example.Models.Specific.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Setter
public class CardRepository implements ICardRepository {

    /**
     * The card's list
     */
    private List<Card> cards;

    /**
     * The database
     */
    private final Database database;

    /**
     * The automapper
     */
    private final AutoMapper autoMapper;

    /**
     * The ORM's repositories
     */
    private final IPreccenseRepository preccenseRepository;

    private final ITypeRepository typeRepository;


    public CardRepository(Database database, AutoMapper autoMapper, IPreccenseRepository preccenseRepository, ITypeRepository typeRepository) {
        this.database = database;
        this.autoMapper = autoMapper;
        this.preccenseRepository = preccenseRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public Card addEntityCard(AddEntityCardDTO addEntityCardDTO) {
        EntityCard entityCard = AutoMapper.map(addEntityCardDTO, EntityCard.class);
        entityCard.setPreccense(preccenseRepository.getPreccenseById(addEntityCardDTO.getPreccenseID()));
        return entityCard;
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        SkillCard skillCard = AutoMapper.map(addSkillCardDTO, SkillCard.class);
        skillCard.setPreccense(preccenseRepository.getPreccenseById(addSkillCardDTO.getPreccenseID()));
        skillCard.setCardType(typeRepository.getTypeSkillCardById(addSkillCardDTO.getTypeID()));
        return AutoMapper.map(addSkillCardDTO, SkillCard.class);
    }

    @Override
    public List<CardDTO> getCards() {

        List<CardDTO> cardsDTO = new ArrayList<>();
        Preccense preccense;


        if (cards.isEmpty()){return cardsDTO;}

        for (Card card : cards){
            if (!card.isDeleted()){
                preccense = card.getPreccense();
                AssignCardTypeGeneral(cardsDTO, preccense, card);
            }
        }

        return cardsDTO;
    }

    private void AssignCardTypeGeneral(List<CardDTO> cardsDTO, Preccense preccense, Card card) {
        EntityCardDTO entityCardDTO;
        CardType skillCardType;
        SkillCardDTO skillCardDTO;
        SkillCard skillCard;
        if (card instanceof EntityCard){
            entityCardDTO = AutoMapper.map((EntityCard)card, EntityCardDTO.class);
            entityCardDTO.setColorPersistence(preccense.getName());
            entityCardDTO.setNamePersistence(preccense.getColor());
            cardsDTO.add(entityCardDTO);

        } else {
            skillCard = (SkillCard) card;
            skillCardType = skillCard.getCardType();
            skillCardDTO = AutoMapper.map((SkillCard)card, SkillCardDTO.class);
            skillCardDTO.setColorPersistence(preccense.getColor());
            skillCardDTO.setNamePersistence(preccense.getName());
            skillCardDTO.setTypeName(skillCardType.getName());
            cardsDTO.add(AutoMapper.map((SkillCard)card, SkillCardDTO.class));
        }
    }

    @Override
    public List<CardDTO> getCardsByPreccense(Long preccenseID) {

        List<CardDTO> cardsDTO = new ArrayList<>();
        Preccense preccense = preccenseRepository.getPreccenseById(preccenseID);

        if(preccense == null){return null;}

        if (cards.isEmpty()){return cardsDTO;}

        for (Card card : cards){
            if (!card.isDeleted()){
                AssignCardTypeGeneral(cardsDTO, preccense, card);
            }
        }

        return cardsDTO;
    }

    @Override
    public CardDTO getCardById(Long id) {

        Card card = database.find(Card.class, id);
        if (card == null || card.isDeleted()){ return null; }
        Preccense preccense = preccenseRepository.getPreccenseById(card.getPreccenseID());
        EntityCardDTO entityCardDTO;
        SkillCardDTO skillCardDTO;
        SkillCard skillCard;
        CardType skillCardType;
        if (card instanceof EntityCard){

            entityCardDTO = AutoMapper.map((EntityCard)card, EntityCardDTO.class);
            entityCardDTO.setColorPersistence(preccense.getColor());
            entityCardDTO.setNamePersistence(preccense.getName());
            return AutoMapper.map(entityCardDTO, CardDTO.class);

        } else {
            skillCard = (SkillCard) card;
            skillCardType = skillCard.getCardType();
            skillCardDTO = AutoMapper.map((SkillCard)card, SkillCardDTO.class);
            skillCardDTO.setColorPersistence(preccense.getColor());
            skillCardDTO.setNamePersistence(preccense.getName());
            skillCardDTO.setTypeName(skillCardType.getName());
            return AutoMapper.map(skillCardDTO, CardDTO.class);
        }
    }

    @Override
    public boolean deleteCard(Long id) {
        Card card = database.find(Card.class, id);
        if (card == null || card.isDeleted()){ return false; }
        card.setDeleted(true);
        this.database.save(card);
        return true;
    }

    @Override
    public boolean saveChanges(Card card) {
        this.database.save(card);
        return true;
    }
}
