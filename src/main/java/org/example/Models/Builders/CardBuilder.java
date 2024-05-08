package org.example.Models.Builders;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Models.BaseModel;
import org.example.Models.Card;
import org.example.Models.Specific.Preccense;

@Data
@SuperBuilder
public class CardBuilder{

    public static Card build(String name, int level, String description, boolean deleted, Long preccenseID, Preccense preccense) {
        Card cardBuilt = Card.builder()
                .level(level)
                .description(description)
                .deleted(deleted)
                .preccenseID(preccenseID)
                .preccense(preccense)
                .build();
        cardBuilt.setName(name);
        return cardBuilt;
    }
}
