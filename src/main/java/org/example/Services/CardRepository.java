package org.example.Services;

import io.ebean.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.Helpers.AutoMapper;
import org.example.Interfaces.ICardRepository;
import org.example.Models.Card;
import org.example.Models.Specific.*;

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

    private final AutoMapper autoMapper;


    public CardRepository(Database database, AutoMapper autoMapper) {
        this.database = database;
        this.autoMapper = autoMapper;
    }

    @Override
    public Card addEntityCard(AddEntityCardDTO addEntityCardDTO) {
        return AutoMapper.map(addEntityCardDTO, EntityCard.class);
    }

    @Override
    public Card addSkillCard(AddSkillCardDTO addSkillCardDTO) {
        return AutoMapper.map(addSkillCardDTO, SkillCard.class);
    }

    @Override
    public List<CardDTO> getCards() {
        return List.of();
    }

    @Override
    public List<CardDTO> getCardsByPreccense(Long preccenseID) {
        return List.of();
    }

    @Override
    public CardDTO getCardsById(Long id) {
        return null;
    }

    @Override
    public boolean deleteCard(Long id) {
        return false;
    }

    @Override
    public boolean saveChanges(Card card) {
        this.database.save(card);
        return true;
    }
}
