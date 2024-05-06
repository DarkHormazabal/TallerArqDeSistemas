package org.example.Models.Builders;


import org.example.Models.BaseModel;
import org.example.Models.Specific.CardType;

public class CardTypeBuilder {
    private String name;

    public CardTypeBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CardType build() {
        CardType cardType = new CardType();
        cardType.setName(name);
        return cardType;
    }
}
