package org.example.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Cart abstract Class.
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
    private int level;

    /**
     * The description.
     */
    private String description;

    /**
     * The deleted.
     */
    private boolean deleted;

}
