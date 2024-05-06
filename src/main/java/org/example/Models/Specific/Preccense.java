package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Preccense Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Preccense extends BaseModel {

    /**
     * The Name.
     * All tables have name's attribute, therefore is implemented here
     */
    @NotNull
    private String name;
    /**
     * The color.
     */
    @NotNull
    private String color;

}
