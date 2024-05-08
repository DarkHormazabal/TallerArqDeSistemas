package org.example.Builders;

import lombok.experimental.SuperBuilder;
import org.example.Models.Specific.CardType;

@SuperBuilder
public class CardTypeBuilder {


    public static CardType build (String name){
        CardType cardType = CardType.builder().build();
        cardType.setName(name);
        return cardType;
    }
}
