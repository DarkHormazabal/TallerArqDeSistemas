package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.Card;

import javax.persistence.*;

/**
 * SkillCard Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@MappedSuperclass
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
    private Long typeID;

    /**
     * The type.
     */
    @NotNull
    private CardType type;


    public SkillCard(String name, int level, String description, String typeCard, boolean deleted, Long preccenseID, Preccense preccense, CardType type, int power) {
        super(level, description, typeCard, deleted, preccenseID, preccense);
        this.typeID = type.getId();
        this.type = type;
        this.power = power;
        this.setName(name);
    }
}
