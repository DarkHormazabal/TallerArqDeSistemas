package org.example.Models.Specific;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class CardType extends BaseModel {

    /**
     * Card Type haven't atributtes in specific, ID and name have the BaseModel
     */


}
