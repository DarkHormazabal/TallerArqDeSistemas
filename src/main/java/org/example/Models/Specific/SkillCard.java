package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.Card;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * SkillCard Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@Getter
@Setter
@Entity
public class SkillCard extends Card {

    /**
     * The power.
     */
    @NotNull
    private int power;

    /**
     * The typeID.
     */
    @NotNull
    private long typeID;

    private CardType cardType;

    public SkillCard(String name, int level, String description, boolean deleted, Long preccenseID, Preccense preccense, int power, long typeID, CardType cardType) {
        super(level, description, deleted, preccenseID, preccense);
        this.power = power;
        this.typeID = typeID;
        this.cardType = cardType;
        this.setName(name);
    }
}
