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

    public SkillCardDTO(Long id, String name, int level, String description, String typeCard, PreccenseDTO preccenseDTO,CardTypeDTO type, int power) {
        super(id, name, level, description, typeCard, preccenseDTO);
        this.type = type;
        this.power = power;
    }
}
