package org.example.DTO;

import io.ebean.annotation.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Adding SkillCard by DTO
 */

@ToString
@Getter
@Setter
public class AddSkillCardDTO {

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
    private Long preccenseID;

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
}
