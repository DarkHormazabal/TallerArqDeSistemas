package org.example.Models;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.Specific.Preccense;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Card abstract Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public abstract class Card extends BaseModel{

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
     * The deleted.
     */
    @NotNull
    private boolean deleted;

    /**
     * The deleted.
     */
    @NotNull
    private Long preccenseID;

    private Preccense preccense;

    public Card() {
        this.deleted = false;
    }
}
