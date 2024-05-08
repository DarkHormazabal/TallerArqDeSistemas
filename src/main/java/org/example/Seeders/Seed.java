package org.example.Seeders;

import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Builders.CardTypeBuilder;
import org.example.Models.Builders.CardBuilder;
import org.example.Models.Builders.EntityCardBuilder;
import org.example.Models.Builders.SkillCardBuilder;
import org.example.Models.Concretes.ConcreteCard;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;

public class Seed {

    private ICardRepository cardRepository;

    private IPreccenseRepository preccenseRepository;

    private ITypeRepository typeRepository;

    public Seed(ICardRepository cardRepository, IPreccenseRepository preccenseRepository, ITypeRepository typeRepository) {
        this.cardRepository = cardRepository;
        this.preccenseRepository = preccenseRepository;
        this.typeRepository = typeRepository;
    }

    public Preccense PreccenseBuilder(String name, String color){

        /**Build the Preccense*/
        Preccense preccense = PreccenseBuilder(name, color);

        /**retornando al utilizar el sistema para añadir al edificio*/
        return preccenseRepository.addPreccenseCard(preccense);

    }

    public CardType TypeBuilder(String name){
        /**Build the SkillCard's type*/
        CardType cardType = new CardTypeBuilder()
                .name(name)
                .build();

        /**retornando al utilizar el sistema para añadir al edificio*/
        return typeRepository.addTypeSkillCard(cardType);
    }

    public EntityCard EntityCardBuilder(String name,int level, String description
            , Long preccenseID, Preccense preccense, int physicalPower, int magicalPower
            , int physicalProtection, int magicalProtection){
        // Primero, creamos un objeto Card utilizando su Builder
        CardBuilder cardBuilder = new CardBuilder();
        ConcreteCard card = cardBuilder.name(name)
                .description(description)
                .preccenseID(preccenseID)
                .deleted(false)
                .preccense(preccense)
                .build();

        // Luego, utilizamos este objeto Card para construir un objeto EntityCard
        EntityCard entityCard = new EntityCardBuilder()
                .card(card)
                .level(level) // Establece el nivel
                .description(description) // Establece la descripción
                .physicalPower(physicalPower) // Establece el poder físico
                .magicalPower(magicalPower) // Establece el poder mágico
                .physicalProtection(physicalProtection) // Establece la protección física
                .magicalProtection(magicalProtection) // Establece la protección mágica
                .preccense(preccense) // Establece la presencia
                .preccenseID(preccenseID) // Establece el ID de la presencia
                .build(); // Finaliza la construcción del objeto EntityCard;

        return entityCard;

    }

    public SkillCard SkillCardBuilder(String name, int level, String description
            , Long preccenseID, Preccense preccense, int power, long typeID, CardType cardType){

        // Primero, creamos un objeto Card utilizando su Builder
        CardBuilder cardBuilder = new CardBuilder();
        ConcreteCard card = cardBuilder.name(name)
                .description(description)
                .preccenseID(preccenseID)
                .deleted(false)
                .preccense(preccense)
                .build();
        SkillCard skillCard = new SkillCardBuilder()
                .card(card)
                .name(name)
                .level(level)
                .description(description)
                .deleted(false)
                .preccenseID(preccenseID)
                .preccense(preccense)
                .power(power) // Asumí que "power" es un atributo de la clase SkillCardBuilder
                .typeID(typeID) // Asumí que "typeID" es un atributo de la clase SkillCardBuilder
                .cardType(cardType) // Asumí que "cardType" es un atributo de la clase SkillCardBuilder
                .build();

        return skillCard;
    }

    public void Seed(){

        //the preccenses
        Preccense preccense1 = PreccenseBuilder("Fuego", "Rojo");
        Preccense preccense2 = PreccenseBuilder("Tierra", "Verde");
        Preccense preccense3 = PreccenseBuilder("Aire", "Morado");
        Preccense preccense4 = PreccenseBuilder("Agua", "Azul");
        Preccense preccense5 = PreccenseBuilder("Éter", "Amarillo");
        Preccense preccense6 = PreccenseBuilder("Santo", "Blanco");
        Preccense preccense7 = PreccenseBuilder("Destrucción", "Gris Oscuro");

        //the skillcard'types
        CardType cardType1 = TypeBuilder("Physical");
        CardType cardType2 = TypeBuilder("Magical");



    }




}
