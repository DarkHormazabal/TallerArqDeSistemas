package org.example.DTO.CardDTO;

import io.ebean.annotation.NotNull;
import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString// Incluir campos de la clase base en toString
@AllArgsConstructor
@NoArgsConstructor
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

    public EntityCardDTO(String name, int level, String description, String namrPersistence, String colorPersistence, int physicalPower, int magicalPower, int physicalProtection, int magicalProtection) {
        super(name, level, description, namrPersistence, colorPersistence);
        this.physicalPower = physicalPower;
        this.magicalPower = magicalPower;
        this.physicalProtection = physicalProtection;
        this.magicalProtection = magicalProtection;
    }
}
