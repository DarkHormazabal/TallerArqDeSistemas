package org.example.Models;

import io.ebean.annotation.NotNull;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    /**
     * The Version.
     */
    @Version
    private Long version;

    /**
     * Creation date.
     */
    @WhenCreated
    private Instant created;

    /**
     * Modified date.
     */
    @WhenModified
    private Instant modified;

}
