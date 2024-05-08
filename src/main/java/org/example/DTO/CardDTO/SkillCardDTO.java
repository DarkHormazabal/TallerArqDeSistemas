package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class SkillCardDTO extends CardDTO{

    /**
     * The power.
     */

    private int power;

    /**
     * The typeID.
     */

    private String typeName;

    public SkillCardDTO(String name, int level, String description, String namrPersistence, String colorPersistence) {
        super(name, level, description, namrPersistence, colorPersistence);
    }
}
