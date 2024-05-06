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
@ToString(callSuper = true)
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Preccense extends BaseModel {

    /**
     * The color.
     */
    @NotNull
    private String color;

    // Constructor protegido para que no pueda ser instanciado directamente
    public Preccense() {
        super();
    }

    // Método estático para obtener una instancia del Builder
    public static PreccenseBuilder builder() {
        return new PreccenseBuilder();
    }

}
