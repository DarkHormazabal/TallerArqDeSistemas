package org.example.Models.Builders;

import io.ebeaninternal.server.util.Str;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.Models.Specific.CardType;

@Data
@SuperBuilder
public class CardTypeBuilder {
    private String name;

    public CardType build(String name) {
        CardType cardType = CardType.builder().build();
        cardType.setName(name);
        return cardType;
    }
}
