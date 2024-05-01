package org.example.Models.Specific;

import lombok.*;
import org.example.Models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * CardType Class.
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
public class CardTypeBySon extends BaseModel {

    /**
     * Card Type haven't atributtes in specific, ID and name have the BaseModel
     */

}
