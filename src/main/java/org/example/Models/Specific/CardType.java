package org.example.Models.Specific;

import io.ebean.annotation.NotNull;
import lombok.*;
import org.example.Models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * CardType Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString(callSuper = true)
@MappedSuperclass
@Getter
@Setter
@Builder
@Entity
public class CardType extends BaseModel {

    /**
     * Card Type haven't atributtes in specific, ID and name have the BaseModel
     */
    public CardType() {
        super();
    }

    // Método estático para obtener una instancia del Builder
    public static CardTypeBuilder builder() {
        return new CardTypeBuilder();
    }

}
