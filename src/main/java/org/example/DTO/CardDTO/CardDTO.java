package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CardDTO {

    /**
     * The Name.
     * All tables have name's attribute, therefore is implemented here
     */
    @NotNull
    private String name;

    /**
     * The level.
     */
    @NotNull
    private int level;

    /**
     * The description.
     */
    @NotNull
    private String description;

}
