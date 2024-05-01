package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;

public class SkillCardDTO extends CardDTO{

    /**
     * The power.
     */
    @NotNull
    private int power;

    /**
     * The typeID.
     */
    @NotNull
    private String typeName;

}
