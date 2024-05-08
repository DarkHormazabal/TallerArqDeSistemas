package org.example.Models.Builders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

@Data
@SuperBuilder
public class SkillCardBuilder{

    public static SkillCard build(Card card, int power, Long typeID, CardType cardType) {
        SkillCard skillCard = SkillCard.builder().power(power)
                .typeID(typeID)
                .cardType(cardType)
                .build();

        skillCard.setName(card.getName());
        skillCard.setDescription(card.getDescription());
        skillCard.setDeleted(card.isDeleted());
        skillCard.setLevel(card.getLevel());
        skillCard.setPreccense(card.getPreccense());
        skillCard.setPreccenseID(card.getPreccenseID());

        return skillCard;

    }
}
