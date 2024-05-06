package org.example.Models.Builders;

import org.example.Models.Concretes.ConcreteCard;
import org.example.Models.Specific.Preccense;

public class ConcreteCardBuilder {
    private String name;
    private int level;
    private String description;
    private boolean deleted;
    private Long preccenseID;
    private Preccense preccense;

    public ConcreteCardBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ConcreteCardBuilder level(int level) {
        this.level = level;
        return this;
    }

    public ConcreteCardBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ConcreteCardBuilder deleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public ConcreteCardBuilder preccenseID(Long preccenseID) {
        this.preccenseID = preccenseID;
        return this;
    }

    public ConcreteCardBuilder preccense(Preccense preccense) {
        this.preccense = preccense;
        return this;
    }

    public ConcreteCard build() {
        ConcreteCard card = new ConcreteCard();
        card.setName(name);
        card.setLevel(level);
        card.setDescription(description);
        card.setDeleted(deleted);
        card.setPreccenseID(preccenseID);
        card.setPreccense(preccense);
        return card;
    }
}
