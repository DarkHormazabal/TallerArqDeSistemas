package org.example.Builders;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import org.example.Models.BaseModel;
import org.example.Models.Card;
import org.example.Models.Specific.Preccense;

@Builder
public class CardBuilder extends BaseModel {

    public static Card build(long id,String name,int level, String description,boolean deleted, Long preccenseID, Preccense
    preccense){
        Card cardBuilt = Card.builder()
                .level(level)
                .description(description)
                .deleted(deleted)
                .preccenseID(preccenseID)
                .preccense(preccense)
                .build();
        cardBuilt.setId(id);
        cardBuilt.setName(name);
        return cardBuilt;
    }
}
