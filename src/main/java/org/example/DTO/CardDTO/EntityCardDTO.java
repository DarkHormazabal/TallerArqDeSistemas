package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

@ToString
@Getter
@Setter
public class EntityCardDTO extends CardDTO{

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

    public EntityCardDTO(String name, int level, String description, String namrPersistence, String colorPersistence) {
        super(name, level, description, namrPersistence, colorPersistence);
    }
}
