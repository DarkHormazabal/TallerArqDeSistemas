package org.example.Services;

import io.ebean.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.Builders.CardBuilder;
import org.example.Builders.EntityCardBuilder;
import org.example.Builders.SkillCardBuilder;
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
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class CardRepository implements ICardRepository {

    /**
     * The card's list
     */
    private List<Card> cards;

    /**
     * The database
     */
    private final Database database;
    ;

    /**
     * The ORM's repositories
     */
    private final IPreccenseRepository preccenseRepository;

    private final ITypeRepository typeRepository;

    @Override
    public Card addEntityCard(AddEntityCardDTO addEntityCardDTO) {
        Preccense FoundPreccense = preccenseRepository.getPreccenseById(addEntityCardDTO.getPreccenseID());
        //automapping
        Card card = CardBuilder.build(
                addEntityCardDTO.getName(),
                addEntityCardDTO.getLevel(),
                addEntityCardDTO.getDescription(),
                false,
                addEntityCardDTO.getPreccenseID(),
                FoundPreccense);

        EntityCard entityCard = EntityCardBuilder.build(card
                , addEntityCardDTO.getPhysicalPower()
                , addEntityCardDTO.getMagicalPower()
                , addEntityCardDTO.getPhysicalProtection(),
                addEntityCardDTO.getMagicalProtection());
        //change your preccense
        this.database.save(entityCard);
        return entityCard;
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        Preccense FoundPreccense = preccenseRepository.getPreccenseById(addSkillCardDTO.getPreccenseID());
        //automapping
        Card card = CardBuilder.build(
                addSkillCardDTO.getName(),
                addSkillCardDTO.getLevel(),
                addSkillCardDTO.getDescription(),
                false,
                addSkillCardDTO.getPreccenseID(),
                FoundPreccense);
        //automapping
        CardType foundtype = typeRepository.getTypeSkillCardById(addSkillCardDTO.getTypeID());
        SkillCard skillCard = SkillCardBuilder.build(card,
                addSkillCardDTO.getPower(),
                addSkillCardDTO.getTypeID(),
                foundtype);
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
        Card card = database.find(SkillCard.class, name);//find tha card
        if(card == null){
            card = database.find(EntityCard.class, name);
        }
        if(card.isDeleted()) return null;
        Preccense preccense = preccenseRepository.getPreccenseById(card.getPreccenseID());
        card.setPreccense(preccense);
        if(card instanceof SkillCard) {
            CardType type = typeRepository.getTypeSkillCardById(((SkillCard) card).getTypeID());
            ((SkillCard) card).setCardType(type);
        }

        return card;
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
    public List<Card> getCards() {


        List<EntityCard> entityCardList = this.database.find(EntityCard.class)
                .findList(); // Supongamos que tienes una lista de EntityCard
        List<SkillCard> skillCardList = this.database.find(SkillCard.class)
                .findList(); // Supongamos que tienes una lista de SkillCard

        List<Card> cardList = new ArrayList<>();
        List<Card> cardList2 = new ArrayList<>();
        cardList.addAll(entityCardList);
        cardList.addAll(skillCardList);

        for (Card card : cardList) {
            if (!card.isDeleted()) {
                card.setPreccense(this.preccenseRepository.getPreccenseById(card.getPreccenseID()));

                if(card instanceof SkillCard) {

                    ((SkillCard) card).setCardType(this.typeRepository.getTypeSkillCardById(((SkillCard) card).getTypeID()));

                }

                cardList2.add(card);
            }
        }

        return cardList2;

    }

    @Override
    public List<Card> getCardsByPreccense(Long preccenseID) {


        List<EntityCard> entityCardList = this.database.find(EntityCard.class)
                .where().eq("preccenseID", preccenseID).findList();// Supongamos que tienes una lista de EntityCard
        List<SkillCard> skillCardList = this.database.find(SkillCard.class)
                .where().eq("preccenseID", preccenseID).findList();
        //is similar, but preccense is found by id sent by client
        List<Card> cardList = new ArrayList<>();
        List<Card> cardList2 = new ArrayList<>();
        cardList.addAll(entityCardList);
        cardList.addAll(skillCardList);


        if (cards.isEmpty()){return cardList;}

        for (Card card : cardList) {
            if (!card.isDeleted() && preccenseID.equals(card.getPreccenseID())) {
                card.setPreccense(this.preccenseRepository.getPreccenseById(card.getPreccenseID()));

                if(card instanceof SkillCard) {

                    ((SkillCard) card).setCardType(this.typeRepository.getTypeSkillCardById(((SkillCard) card).getTypeID()));

                }

                cardList2.add(card);
            }
        }

        return cardList2;
    }

    @Override
    public Card getCardById(Long id) {

        Card card = database.find(SkillCard.class, id);//find tha card
        if(card == null){
            card = database.find(EntityCard.class, id);
        }
        if(card.isDeleted()) return null;
        Preccense preccense = preccenseRepository.getPreccenseById(card.getPreccenseID());
        card.setPreccense(preccense);
        if(card instanceof SkillCard) {
            CardType type = typeRepository.getTypeSkillCardById(((SkillCard) card).getTypeID());
            ((SkillCard) card).setCardType(type);
        }

        return card;
    }

    @Override
    public boolean deleteCard(Long id) {
        Card card = database.find(SkillCard.class, id);//find tha card
        if(card == null){
            card = database.find(EntityCard.class, id);
        }
        if (card == null){ return false; }
        this.database.delete(card);
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
