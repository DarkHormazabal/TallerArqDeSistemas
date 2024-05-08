package org.example.Models;

import io.ebean.annotation.NotNull;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;


/**
 * Base Class.
 *
 * @author Matias Orellana Hormazábal.
 */
@ToString
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseModel {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The Name.
     * All tables have name's attribute, therefore is implemented here
     */
    @NotNull
    private String name;

}
