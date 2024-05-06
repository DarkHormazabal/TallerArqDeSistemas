package org.example.Models.Builders;

import org.example.Models.Specific.Preccense;


public class PreccenseBuilder {
    private String name;
    private String color;

    public PreccenseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PreccenseBuilder color(String color) {
        this.color = color;
        return this;
    }

    public Preccense build() {
        Preccense preccense = new Preccense();
        preccense.setName(name);
        preccense.setColor(color);
        return preccense;
    }
}
