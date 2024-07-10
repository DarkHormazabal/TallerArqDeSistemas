package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.Card;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * EntityCard Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@MappedSuperclass
@Getter
@Setter
@Entity
public class EntityCard extends Card {

    /**
     * The physicalPower.
     */
    @NotNull
    private int physicalPower;

    /**
     * The magicalPower.
     */
    @NotNull
    private int magicalPower;

    /**
     * The physicalProtection.
     */
    @NotNull
    private int physicalProtection;

    /**
     * The magicalProtection.
     */
    @NotNull
    private int magicalProtection;


    public EntityCard(String name, int level, String description, String typeCard, boolean deleted, Long preccenseID, Preccense preccense, int physicalPower, int magicalPower, int physicalProtection, int magicalProtection) {
        super(level, description, typeCard, deleted, preccenseID, preccense);
        this.physicalPower = physicalPower;
        this.magicalPower = magicalPower;
        this.physicalProtection = physicalProtection;
        this.magicalProtection = magicalProtection;
        this.setName(name);
    }
}
