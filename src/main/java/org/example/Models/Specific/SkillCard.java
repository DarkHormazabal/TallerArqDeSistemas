package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.Card;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

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

    @ManyToOne
    private CardType cardType;

    public SkillCard(String name, int level, String description, boolean deleted, Long preccenseID, Preccense preccense, int power, Long typeID, CardType cardType) {
        super(level, description, deleted, preccenseID, preccense);
        this.power = power;
        this.typeID = typeID;
        this.cardType = cardType;
        this.setName(name);
    }
}
