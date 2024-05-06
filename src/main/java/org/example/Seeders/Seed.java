package org.example.Seeders;

import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.BaseModel;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.Preccense;

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
        Preccense preccense = Preccense.builder().name(name).color(color).build();

        /**retornando al utilizar el sistema para añadir al edificio*/
        return preccenseRepository.addPreccenseCard(preccense);

    }

    public CardType TypeBuilder(String name){
        /**Build the SkillCard's type*/
        CardType cardType = CardType.builder().name(name).build();

        /**retornando al utilizar el sistema para añadir al edificio*/
        return typeRepository.addTypeSkillCard(cardType);
    }


}
