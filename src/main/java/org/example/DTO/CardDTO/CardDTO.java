package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.MappedSuperclass;

/**
 * Deploy the cards to client
 */

@ToString
@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class CardDTO {

    /**
     * The id.
     * All tables have name's attribute, therefore is implemented here
     */

    private Long id;

    /**
     * The Name.
     * All tables have name's attribute, therefore is implemented here
     */

    private String name;

    /**
     * The level.
     */

    private int level;

    /**
     * The description.
     */

    private String description;

    /**
     * The typeCard.
     */

    private String typeCard;

    private PreccenseDTO preccenseDTO;


}
