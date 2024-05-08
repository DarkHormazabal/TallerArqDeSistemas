package org.example.Builders;

import org.example.Models.Specific.Preccense;

public class PreccenseBuilder {
    public static Preccense build(String name, String color) {
        Preccense preccense = Preccense.builder().color(color).build();
        preccense.setName(name);
        return preccense;
    }
}
