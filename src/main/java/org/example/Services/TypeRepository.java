package org.example.Services;

import io.ebean.Database;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Specific.CardType;

import java.util.List;

/**
 * Similar to Preccense, but only applied to SkillCard
 */
@Slf4j
@Builder
@Getter
@Setter
public class TypeRepository implements ITypeRepository {

    private final Database database;

    public TypeRepository(Database database) {
        this.database = database;
    }

    @Override
    public CardType getTypeSkillCardById(Long id) {
        return database.find(CardType.class, id);
    }

    @Override
    public void addTypeSkillCard(List<CardType> cardTypeList) {
        this.database.insertAll(cardTypeList);
    }

}
