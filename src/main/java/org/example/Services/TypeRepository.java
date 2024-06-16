package org.example.Services;

import io.ebean.Database;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;

import java.util.List;

/**
 * Similar to Preccense, but only applied to SkillCard
 */
@Slf4j
@AllArgsConstructor
public class TypeRepository implements ITypeRepository {

    /**
     * The database
     */
    private final Database database;

    /**
     * The types list
     */
    private List<CardType> cardTypes;

    @Override
    public CardType getTypeSkillCardById(Long id) {
        return database.find(CardType.class, id);
    }

    @Override
    public CardType getTypeSkillCardByName(String cardTypeName) {
        return this.database.find(CardType.class).where().eq("name", cardTypeName).findOne();
    }

    @Override
    public void addTypeSkillCard(CardType cardType) {
        this.database.insert(cardType);
    }

    @Override
    public List<CardType> getCardTypes() {
        this.cardTypes = database.find(CardType.class).findList();
        return this.cardTypes;
    }
}
