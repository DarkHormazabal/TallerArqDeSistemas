package org.example.Models.Builders;


import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;

public class EntityCardBuilder {
    private String name;
    private int level;
    private String description;
    private boolean deleted;
    private Long preccenseID;
    private Preccense preccense;
    private int physicalPower;
    private int magicalPower;
    private int physicalProtection;
    private int magicalProtection;

    public EntityCardBuilder name(String name) {
        this.name = name;
        return this;
    }

    public EntityCardBuilder level(int level) {
        this.level = level;
        return this;
    }

    public EntityCardBuilder description(String description) {
        this.description = description;
        return this;
    }

    public EntityCardBuilder deleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public EntityCardBuilder preccenseID(Long preccenseID) {
        this.preccenseID = preccenseID;
        return this;
    }

    public EntityCardBuilder preccense(Preccense preccense) {
        this.preccense = preccense;
        return this;
    }

    public EntityCardBuilder physicalPower(int physicalPower) {
        this.physicalPower = physicalPower;
        return this;
    }

    public EntityCardBuilder magicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
        return this;
    }

    public EntityCardBuilder physicalProtection(int physicalProtection) {
        this.physicalProtection = physicalProtection;
        return this;
    }

    public EntityCardBuilder magicalProtection(int magicalProtection) {
        this.magicalProtection = magicalProtection;
        return this;
    }

    public EntityCard build() {
        EntityCard entityCard = new EntityCard();
        entityCard.setName(name);
        entityCard.setLevel(level);
        entityCard.setDescription(description);
        entityCard.setDeleted(deleted);
        entityCard.setPreccenseID(preccenseID);
        entityCard.setPreccense(preccense);
        entityCard.setPhysicalPower(physicalPower);
        entityCard.setMagicalPower(magicalPower);
        entityCard.setPhysicalProtection(physicalProtection);
        entityCard.setMagicalProtection(magicalProtection);
        return entityCard;
    }
}