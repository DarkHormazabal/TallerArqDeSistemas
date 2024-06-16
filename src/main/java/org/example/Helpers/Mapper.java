package org.example.Helpers;

import org.example.DTO.CardDTO.CardTypeDTO;
import org.example.DTO.CardDTO.EntityCardDTO;
import org.example.DTO.CardDTO.PreccenseDTO;
import org.example.DTO.CardDTO.SkillCardDTO;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

public class Mapper {

    //mapping entities cards
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

    //mapping skills cards
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

    //mapping type cards
    public static CardTypeDTO toCardTypeDTO(CardType cardType) {
        if (cardType == null) {
            return null;
        }

        CardTypeDTO dto = new CardTypeDTO(
                cardType.getName()
        );

        return dto;
    }

    //mapping preccences
    public static PreccenseDTO toPreccenseDTO(Preccense preccense) {
        if (preccense == null) {
            return null;
        }

        PreccenseDTO dto = new PreccenseDTO(
                preccense.getName(),
                preccense.getColor()
        );

        return dto;
    }

}
