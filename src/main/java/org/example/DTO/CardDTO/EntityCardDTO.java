package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;

public class EntityCardDTO extends CardDTO{

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
