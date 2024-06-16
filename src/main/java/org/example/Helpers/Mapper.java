package org.example.Helpers;

import org.example.DTO.CardDTO.EntityCardDTO;
import org.example.DTO.CardDTO.SkillCardDTO;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.SkillCard;

public class Mapper {

    public static EntityCardDTO toEntityDTO(EntityCard card) {
        if (card == null) {
            return null;
        }

        EntityCardDTO dto = new EntityCardDTO(
                card.getName(),
                card.getLevel(),
                card.getDescription(),
                card.getPreccense().getName(),
                card.getPreccense().getColor(),
                card.getPhysicalPower(),
                card.getMagicalPower(),
                card.getPhysicalProtection(),
                card.getMagicalProtection()
        );

        return dto;
    }

    public static SkillCardDTO toSkillDTO(SkillCard card) {
        if (card == null) {
            return null;
        }

        SkillCardDTO dto = new SkillCardDTO(
                card.getName(),
                card.getLevel(),
                card.getDescription(),
                card.getPreccense().getName(),
                card.getPreccense().getColor(),
                card.getPower(),
                card.getCardType().getName()
        );

        return dto;
    }

    public static CardTypeDTO toSkillDTO(TypeCard cardType) {
        if (card == null) {
            return null;
        }

        SkillCardDTO dto = new SkillCardDTO(
                card.getName(),
                card.getLevel(),
                card.getDescription(),
                card.getPreccense().getName(),
                card.getPreccense().getColor(),
                card.getPower(),
                card.getCardType().getName()
        );

        return dto;
    }

}
