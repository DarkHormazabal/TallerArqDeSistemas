package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

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

    /**
     * The persistence's name.
     */
    @NotNull
    private String namePersistence;

    /**
     * The persistence's color.
     */
    @NotNull
    private String colorPersistence;

}
