package org.example.Builders;

import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

public class SkillCardBuilder {

    public static SkillCard build(Card card, CardType type, int power) {

        SkillCard skillCard = new SkillCard(card.getName(), card.getLevel(),
                card.getDescription(),
                "SkillCard",
                card.isDeleted(),
                card.getPreccenseID(),
                card.getPreccense(), type, power);
        skillCard.setId(card.getId());
        return skillCard;

    }
}
