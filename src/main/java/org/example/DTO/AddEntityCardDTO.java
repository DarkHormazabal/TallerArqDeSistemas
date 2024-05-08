package org.example.DTO;

import io.ebean.annotation.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Adding EntityCard by DTO
 */

@ToString
@Getter
@Setter
public class AddEntityCardDTO {

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
     * The deleted.
     */

    private Long preccenseID;

    /**
     * The physicalPower.
     */

    private int physicalPower;

    /**
     * The magicalPower.
     */

    private int magicalPower;

    /**
     * The physicalProtection.
     */

    private int physicalProtection;

    /**
     * The magicalProtection.
     */

    private int magicalProtection;


}
