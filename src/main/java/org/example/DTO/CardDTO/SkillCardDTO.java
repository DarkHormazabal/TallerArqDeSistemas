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
     * The type.
     */

    private CardTypeDTO type;

    public SkillCardDTO(String name, int level, String description, PreccenseDTO preccenseDTO,CardTypeDTO type, int power) {
        super(name, level, description, preccenseDTO);
        this.type = type;
        this.power = power;
    }
}
