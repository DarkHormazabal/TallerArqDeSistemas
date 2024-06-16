package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillCardDTO extends CardDTO{

    /**
     * The power.
     */

    private int power;

    /**
     * The typeID.
     */

    private String typeName;

    public SkillCardDTO(String name, int level, String description, String namrPersistence, String colorPersistence, int power, String typeName) {
        super(name, level, description, namrPersistence, colorPersistence);
        this.power = power;
        this.typeName = typeName;
    }
}
