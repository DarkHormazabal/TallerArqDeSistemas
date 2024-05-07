package org.example.Models.Builders;

import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

public class SkillCardBuilder {
    private Card card;
    private String name;
    private int level;
    private String description;
    private boolean deleted;
    private Long preccenseID;
    private Preccense preccense;
    private int power;
    private Long typeID;
    private CardType cardType;

    public SkillCardBuilder card(Card card) {
        this.card = card;
        return this;
    }

    public SkillCardBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SkillCardBuilder level(int level) {
        this.level = level;
        return this;
    }

    public SkillCardBuilder description(String description) {
        this.description = description;
        return this;
    }

    public SkillCardBuilder deleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public SkillCardBuilder preccenseID(Long preccenseID) {
        this.preccenseID = preccenseID;
        return this;
    }

    public SkillCardBuilder preccense(Preccense preccense) {
        this.preccense = preccense;
        return this;
    }

    public SkillCardBuilder power(int power) {
        this.power = power;
        return this;
    }

    public SkillCardBuilder typeID(Long typeID) {
        this.typeID = typeID;
        return this;
    }

    public SkillCardBuilder cardType(CardType cardType) {
        this.cardType = cardType;
        return this;
    }

    public SkillCard build() {
        SkillCard skillCard = new SkillCard();
        skillCard.setName(name);
        skillCard.setLevel(level);
        skillCard.setDescription(description);
        skillCard.setDeleted(deleted);
        skillCard.setPreccenseID(preccenseID);
        skillCard.setPreccense(preccense);
        skillCard.setPower(power);
        skillCard.setTypeID(typeID);
        skillCard.setCardType(cardType);
        return skillCard;
    }
}
