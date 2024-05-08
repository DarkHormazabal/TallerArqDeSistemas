package org.example.Interfaces;

import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;

import java.util.List;

public interface ITypeRepository {

    /**
     * @return
     * @param id to view
     * find type by id
     */
    public CardType getTypeSkillCardById(Long id);

    public void addTypeSkillCard(CardType cardType);
}
