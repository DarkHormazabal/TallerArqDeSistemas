package org.example.Services;

import io.ebean.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.Interfaces.ICardRepository;
import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.CardTypeBySon;
import org.example.Models.Specific.Preccense;

import java.util.List;

@Slf4j
@Getter
@Setter
public class CardRepository implements ICardRepository {

    private List<Card> cards;

    private List<CardTypeBySon> cardTypeBySons;

    private List<CardType> cardTypes;

    private List<Preccense> preccenses;

    /**
     * The database
     */
    private final Database database;

    //private final

    public CardRepository(Database database) {
        this.database = database;
    }

    @Override
    public Card addEntityCard(AddEntityCardDTO addEntityCardDTO) {
        return null;
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        return null;
    }

    @Override
    public List<Card> getCards() {
        return List.of();
    }

    @Override
    public List<Card> getCardsByPreccense(Long preccenseID) {
        return List.of();
    }

    @Override
    public Card getCardsById(Long id) {
        return null;
    }

    @Override
    public boolean deleteCard(Long id) {
        return false;
    }

    @Override
    public boolean saveChanges() {
        return false;
    }
}
