package org.example.Helpers;

import org.example.DTO.CardDTO.*;
import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static CardDTO toCardDTO(Card card) {
        if (card == null) {
            return null;
        }

        CardDTO dto;

        if (card instanceof EntityCard) {
            dto = toEntityDTO((EntityCard) card);
        } else {
            dto = toSkillDTO((SkillCard) card);
        }

        return dto;
    }


    //mapping entities cards
    public static EntityCardDTO toEntityDTO(EntityCard card) {


        EntityCardDTO dto = new EntityCardDTO(
                card.getName(),
                card.getLevel(),
                card.getDescription(),
                toPreccenseDTO(card.getPreccense()),
                card.getPhysicalPower(),
                card.getMagicalPower(),
                card.getPhysicalProtection(),
                card.getMagicalProtection()
        );

        return dto;
    }

    //mapping skills cards
    public static SkillCardDTO toSkillDTO(SkillCard card) {

        SkillCardDTO dto = new SkillCardDTO(
                card.getName(),
                card.getLevel(),
                card.getDescription(),
                toPreccenseDTO(card.getPreccense()),
                card.getPower(),
                toCardTypeDTO(card.getCardType())
        );

        return dto;
    }

    public static List<CardDTO> toCardDTOList(List<Card> cards) {

        return cards.stream()
                .map(Mapper::toCardDTO)
                .collect(Collectors.toList());

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

    //mapping the Card's type
    public static List<CardTypeDTO> toCardTypeDTOList(List<CardType> cardTypes) {
        return cardTypes.stream()
                .map(Mapper::toCardTypeDTO)
                .collect(Collectors.toList());
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

    //mapping the preccences
    public static List<PreccenseDTO> toPreccenseDTOList(List<Preccense> preccenses) {
        return preccenses.stream()
                .map(Mapper::toPreccenseDTO)
                .collect(Collectors.toList());
    }

}
