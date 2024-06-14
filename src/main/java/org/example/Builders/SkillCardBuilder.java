package org.example.Builders;

import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

public class SkillCardBuilder {

    public static SkillCard build(Card card, int power, Long typeID, CardType cardType) {

        SkillCard skillCard = new SkillCard(card.getName(), card.getLevel(),
                card.getDescription(), card.isDeleted(),
                card.getPreccenseID(), card.getPreccense()
                , power, typeID, cardType);
        skillCard.setId(card.getId());
        return skillCard;

    }
}
