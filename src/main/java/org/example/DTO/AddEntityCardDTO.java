package org.example.DTO;

import io.ebean.annotation.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddEntityCardDTO {

    /**
     * The Name.
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
     * The deleted.
     */
    @NotNull
    private boolean deleted;

    /**
     * The deleted.
     */
    @NotNull
    private long preccenseId;

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


}