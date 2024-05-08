package org.example.Models.Builders;


import io.ebeaninternal.server.util.Str;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.Models.Card;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;

@Data
@SuperBuilder
public class EntityCardBuilder {

    public static EntityCard build(Card card, int physicalPower, int magicalPower, int physicalProtection, int magicalProtection) {
        EntityCard entityCard = EntityCard.builder().magicalPower(magicalPower)
                .magicalProtection(magicalProtection)
                .physicalPower(physicalPower)
                .physicalProtection(physicalProtection).build();

        entityCard.setName(card.getName());
        entityCard.setLevel(card.getLevel());
        entityCard.setDescription(card.getDescription());
        entityCard.setDeleted(card.isDeleted());
        entityCard.setPreccenseID(card.getPreccenseID());
        entityCard.setPreccense(card.getPreccense());
        entityCard.setPhysicalPower(physicalPower);
        entityCard.setMagicalPower(magicalPower);
        entityCard.setPhysicalProtection(physicalProtection);
        entityCard.setMagicalProtection(magicalProtection);
        return entityCard;
    }
}