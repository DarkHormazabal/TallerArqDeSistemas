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
        //automapping
        EntityCard entityCard = AutoMapper.map(addEntityCardDTO, EntityCard.class);
        //change your preccense
        entityCard.setPreccense(preccenseRepository.getPreccenseById(addEntityCardDTO.getPreccenseID()));
        this.database.save(entityCard);
        return entityCard;
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        //automapping
        SkillCard skillCard = AutoMapper.map(addSkillCardDTO, SkillCard.class);
        //change your preccense
        skillCard.setPreccense(preccenseRepository.getPreccenseById(addSkillCardDTO.getPreccenseID()));
        //change your cardType
        skillCard.setCardType(typeRepository.getTypeSkillCardById(addSkillCardDTO.getTypeID()));
        this.database.save(skillCard);
        return skillCard;
    }

    @Override
    public Card restoreCard(Card findCard) {
        findCard.setDeleted(false);
        return findCard;
    }

    @Override
    public Card Find(String name) {
        Card findCard = database.find(Card.class, name);
        return findCard;
    }

    @Override
    public Card addEntityCardSeeder(Card card) {
        this.database.save(card);
        return card;
    }

    @Override
    public Card addSkillCardSeeder(Card card) {
        this.database.save(card);
        return card;
    }


    @Override
    public List<CardDTO> getCards() {

        List<CardDTO> cardsDTO = new ArrayList<>();//initial cardsDTO

        if (cards.isEmpty()){return cardsDTO;}//is empty, return because is unnecessary do the follow process

        for (Card card : cards){
            //execute this process only when the card isn't deleted (deleted == true)
            if (!card.isDeleted()){
                Preccense preccense = card.getPreccense();//obtain card's preccense
                AssignCardTypeGeneral(cardsDTO, preccense, card);
            }
        }

        return cardsDTO;
    }

    @Override
    public List<CardDTO> getCardsByPreccense(Long preccenseID) {

        //is similar, but preccense is found by id sent by client
        List<CardDTO> cardsDTO = new ArrayList<>();
        Preccense preccense = preccenseRepository.getPreccenseById(preccenseID);//obtain the preccense

        if (cards.isEmpty() || preccense == null){return cardsDTO;}

        for (Card card : cards){
            if (!card.isDeleted()){
                AssignCardTypeGeneral(cardsDTO, preccense, card);
            }
        }

        return cardsDTO;
    }

    @Override
    public CardDTO getCardById(Long id) {

        Card card = database.find(Card.class, id);//find tha card
        if (card == null || card.isDeleted()){ return null; }
        Preccense preccense = card.getPreccense();
        //is similar to than others gets, but don't use the method "AssignCardTypeGeneral"
        //because isn't list
        if (card instanceof EntityCard){

            return AssignEntityCard(preccense, card);

        } else {
            return AssignSkillCard(preccense, card);
        }
    }

    @Override
    public boolean deleteCard(Long id) {
        Card card = database.find(Card.class, id);//find the card
        if (card == null || card.isDeleted()){ return false; }
        card.setDeleted(true);
        this.database.save(card);
        return true;
    }

    private void AssignCardTypeGeneral(List<CardDTO> cardsDTO, Preccense preccense, Card card) {


        //in case EntityCard
        if (card instanceof EntityCard){

            //add this in cardsDTO
            EntityCardDTO entityCardDTO = AssignEntityCard(preccense, card);
            cardsDTO.add(entityCardDTO);

            //in case SkillCard
        } else {

            SkillCardDTO skillCardDTO = AssignSkillCard(preccense, card);
            //add this in cardsDTO
            cardsDTO.add(skillCardDTO);
        }
    }

    private EntityCardDTO AssignEntityCard(Preccense preccense, Card card) {

        EntityCardDTO entityCardDTO = AutoMapper.map((EntityCard)card, EntityCardDTO.class);//Automaping
        //change the atributtes to show
        entityCardDTO.setColorPersistence(preccense.getName());
        entityCardDTO.setNamePersistence(preccense.getColor());
        return entityCardDTO;

    }

    private SkillCardDTO AssignSkillCard(Preccense preccense, Card card) {

        SkillCardDTO skillCardDTO = AutoMapper.map((SkillCard)card, SkillCardDTO.class);//Automaping
        //Your skillCardTYpe
        SkillCard skillCard = (SkillCard) card;
        //only to using the casting
        CardType skillCardType = skillCard.getCardType();

        //change the atributtes to show
        skillCardDTO.setColorPersistence(preccense.getColor());
        skillCardDTO.setNamePersistence(preccense.getName());
        skillCardDTO.setTypeName(skillCardType.getName());
        return skillCardDTO;

    }

}
