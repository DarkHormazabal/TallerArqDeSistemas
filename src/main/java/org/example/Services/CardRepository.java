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
@AllArgsConstructor
public class CardRepository implements ICardRepository {

    /**
     * The card's list
     */
    private List<Card> cards;

    private static long idAcumuler = 0L;

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
        Card card = CardBuilder.build(idAcumuler + 1L,
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
        idAcumuler++;
        this.database.save(entityCard);
        return entityCard;
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        Preccense FoundPreccense = preccenseRepository.getPreccenseById(addSkillCardDTO.getPreccenseID());
        //automapping
        Card card = CardBuilder.build(idAcumuler + 1L,
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
        idAcumuler++;
        this.database.save(skillCard);
        return skillCard;
    }

    //documented in interface
    @Override
    public Card Find(String name) {

        try {
            //find the skillCard
            Card card = this.database.find(SkillCard.class)
                    .fetch("preccense")
                    .fetch("cardType")
                    .where().eq("name", name)
                    .findOne();

            //find the Entitycard
            if(card == null){
                card = this.database.find(EntityCard.class)
                        .fetch("preccense")
                        .where().eq("name", name)
                        .findOne();
            }
            //notfound
            if(card == null || card.isDeleted()) return null;
            return card;

        } catch (Exception e) {
            // Manejar la excepción aquí, por ejemplo, imprimir el mensaje de error
            e.printStackTrace();
            return null;
        }





    }

    //documented in interface
    @Override
    public Card addCardSeeder(Card card) {

        idAcumuler++;
        this.database.save(card);
        return card;
    }


    //documented in interface
    @Override
    public List<Card> getCards() {

        //select all entities with preccenses
        List<EntityCard> entityCardList = this.database.find(EntityCard.class)
                .fetch("preccense")
                .findList();
        //select all skills with preccenses and cardTypes
        List<SkillCard> skillCardList = this.database.find(SkillCard.class)
                .fetch("preccense")
                .fetch("cardType")
                .findList();


        //both cardlists
        List<Card> cardList = new ArrayList<>();
        cardList.addAll(entityCardList);
        cardList.addAll(skillCardList);
        return cardList;

    }

    //documented in interface
    @Override
    public List<Card> getCardsByPreccense(Long preccenseID) {
        //preccense's validation
        Preccense preccense = preccenseRepository.getPreccenseById(preccenseID);
        if(preccense == null) return null;

        //select all entities with preccenses
        List<EntityCard> entityCardList = this.database.find(EntityCard.class)
                .fetch("preccense")
                .where().eq("preccenseID", preccenseID).findList();// Supongamos que tienes una lista de EntityCard

        //select all skills with preccenses and cardTypes
        List<SkillCard> skillCardList = this.database.find(SkillCard.class)
                .fetch("preccense")
                .fetch("cardType")
                .where().eq("preccenseID", preccenseID).findList();

        //is similar, but preccense is found by id sent by client
        List<Card> cardList = new ArrayList<>();
        cardList.addAll(entityCardList);
        cardList.addAll(skillCardList);

        return cardList;
    }

    //documented in interface
    @Override
    public Card getCardById(Long id) {

        //find the Skillcard
        Card card = this.database.find(SkillCard.class)
                .fetch("preccense")
                .fetch("cardType")
                .setId(id)
                .findOne();
        //find the Entitycard
        if(card == null){
            card = this.database.find(EntityCard.class)
                    .fetch("preccense")
                    .setId(id)
                    .findOne();
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

}
