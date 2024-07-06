package org.example.Models;

import io.ebean.annotation.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Models.Specific.Preccense;

import javax.persistence.*;

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
     * The precenseID.
     */
    @NotNull
    private Long preccenseID;
    /**
     * The precense.
     */
    @NotNull
    private Preccense preccense;



}
