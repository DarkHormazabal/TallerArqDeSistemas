package org.example.Seeders;

import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Builders.*;
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
