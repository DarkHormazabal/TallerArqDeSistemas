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
@MappedSuperclass
@Getter
@Setter
@Builder
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

    public SkillCard() {
        super();

    }

    public static SkillCardBuilder skillCardBuilder() {
        return new SkillCardBuilder();
    }
}
