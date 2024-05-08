package org.example.Models.Builders;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.Models.Specific.Preccense;

@Data
@SuperBuilder
public class PreccenseBuilder {

    public static Preccense build(String name, String color) {
        Preccense preccense = Preccense.builder().color(color).build();
        preccense.setName(name);
        return preccense;
    }
}
