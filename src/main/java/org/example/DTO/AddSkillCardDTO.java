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

    private String name;

    /**
     * The level.
     */

    private int level;

    /**
     * The description.
     */

    private String description;


    /**
     * The preccenseID.
     */

    private Long preccenseID;

    /**
     * The power.
     */

    private int power;

    /**
     * The typeID.
     */

    private Long typeID;
}
