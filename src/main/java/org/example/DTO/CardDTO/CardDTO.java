package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

/**
 * Deploy the cards to client
 */

@ToString
@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
public abstract class CardDTO {

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
     * The persistence's name.
     */

    private String namePersistence;

    /**
     * The persistence's color.
     */

    private String colorPersistence;

}
