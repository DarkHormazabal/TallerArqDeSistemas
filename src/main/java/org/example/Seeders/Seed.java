package org.example.Seeders;

import io.ebeaninternal.server.deploy.BeanDescriptor;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.BaseModel;
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

    public EntityCard EntityCardBuilder(String name,int level, String description
            , Long preccenseID, Preccense preccense, int physicalPower, int magicalPower
            , int physicalProtection, int magicalProtection){
            Card card = Card.builder().name(name).description(description).preccenseID(preccenseID)
                    .deleted(false).preccense(preccense).build();
            EntityCard entityCard =
    }

    public SkillCard SkillCardBuilder(String name, int level, String description
            , Long preccenseID, Preccense preccense, int power, long typeID, CardType cardType){

    }


}
