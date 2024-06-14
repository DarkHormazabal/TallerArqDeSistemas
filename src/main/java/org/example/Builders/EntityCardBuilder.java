package org.example.Builders;

import org.example.Models.Card;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;

public class EntityCardBuilder {

    public static EntityCard build(Card card, int physicalPower, int magicalPower, int physicalProtection, int magicalProtection) {

        EntityCard entityCard = new EntityCard(card.getName(), card.getLevel(),
                card.getDescription(), card.isDeleted(),
                card.getPreccenseID(), card.getPreccense(),
                physicalPower, magicalPower,
                physicalProtection, magicalProtection);

        entityCard.setId(card.getId());
        return entityCard;

    }

}
