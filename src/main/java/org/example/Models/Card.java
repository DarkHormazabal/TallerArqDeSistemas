package org.example.Models;

import io.ebean.annotation.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Models.Specific.Preccense;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

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
public class Card extends BaseModel{


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

    @ManyToOne
    private Preccense preccense;

}
