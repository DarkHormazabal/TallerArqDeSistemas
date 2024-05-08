package org.example.Seeders;

import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Builders.*;
import org.example.Models.Card;
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



    public void Seed(){

        //the preccenses
        Preccense preccense1 = PreccenseBuilder.build("Fuego", "Rojo");
        Preccense preccense2 = PreccenseBuilder.build("Tierra", "Verde");
        Preccense preccense3 = PreccenseBuilder.build("Aire", "Morado");
        Preccense preccense4 = PreccenseBuilder.build("Agua", "Azul");
        Preccense preccense5 = PreccenseBuilder.build("Éter", "Amarillo");
        Preccense preccense6 = PreccenseBuilder.build("Santo", "Blanco");
        Preccense preccense7 = PreccenseBuilder.build("Destrucción", "Gris Oscuro");

        //the skillcard'types
        CardType cardType1 = CardTypeBuilder.build("Physical");
        CardType cardType2 = CardTypeBuilder.build("Magical");

        //the CardBuilders
        Card card1 = CardBuilder.build("Bola de fuego", 2,"Hechizo", false, 1L, preccense1);
        Card card2 =


    }




}
