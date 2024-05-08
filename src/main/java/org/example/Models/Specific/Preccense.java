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



}
