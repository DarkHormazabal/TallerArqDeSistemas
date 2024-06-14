package org.example.Seeders;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Database;
import io.ebeaninternal.server.util.Str;
import lombok.AllArgsConstructor;
import org.example.Builders.*;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;
import org.example.Services.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Seed {

    /**
     * The Repositories
     */
    private ICardRepository cardRepository;

    private IPreccenseRepository preccenseRepository;

    private ITypeRepository typeRepository;

    /**
     * The Alphabet available
     */
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz ";
    /**
     * The MayusAlphabet available
     */
    private static final String MayusALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * The Random
     */
    private static final Random random = new Random();

    /**
     * The Seeders
     */
    public void Seeders() {

            /*
            * skilcard's type seeder
            */
            CardType type1 = CardTypeBuilder.build("Physical");
            CardType type2 = CardTypeBuilder.build("Magical");
            this.typeRepository.addTypeSkillCard(type1);
            this.typeRepository.addTypeSkillCard(type2);

            /*
             * pressences's card type seeder
             */
            Preccense preccense1 = PreccenseBuilder.build("Fuego", "Rojo");
            Preccense preccense2 = PreccenseBuilder.build("Tierra", "Verde");
            Preccense preccense3 = PreccenseBuilder.build("Aire", "Morado");
            Preccense preccense4 = PreccenseBuilder.build("Agua", "Azul");
            Preccense preccense5 = PreccenseBuilder.build("Éter", "Amarillo");
            Preccense preccense6 = PreccenseBuilder.build("Santo", "Blanco");
            Preccense preccense7 = PreccenseBuilder.build("Destrucción", "Gris Oscuro");
            this.preccenseRepository.addPreccenseCard(preccense1);
            this.preccenseRepository.addPreccenseCard(preccense2);
            this.preccenseRepository.addPreccenseCard(preccense3);
            this.preccenseRepository.addPreccenseCard(preccense4);
            this.preccenseRepository.addPreccenseCard(preccense5);
            this.preccenseRepository.addPreccenseCard(preccense6);
            this.preccenseRepository.addPreccenseCard(preccense7);

            /*
             * cards seeder
             */
            List<CardType> cardTypes = this.typeRepository.getCardTypes();
            List<Preccense> preccenses = this.preccenseRepository.getPreccenses();


            GenerateCards(20,cardTypes, preccenses);



    }

    /**
     * Method to GenerateCardsSeeder with
     * @param min , min limit
     * @param max , max limit
     */
    public int RandomNumbers(int min, int max){
            if (min > max) {
                    throw new IllegalArgumentException("El valor mínimo no puede ser mayor que el valor máximo.");
            }
            return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Method to GenerateCardsSeeder with
     * @param length to name'length
     */
    public String RandomName(int length){
            //validation with length is zero or negative
            if (length <= 0) {
                    throw new IllegalArgumentException("La longitud del nombre debe ser mayor a 0.");
            }

            //save the name
            StringBuilder name = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                    // Approximately 1/3 probability to add a space, but don't to start
                    // and neither can have 2 spaces
                    if (random.nextInt(0,3) == 0 && i > 0 && name.length() > 2) {
                            name.append(' ');

                    //fisrt letter
                    } else if (i == 0) {
                            name.append(MayusALPHABET.charAt(random.nextInt(MayusALPHABET.length())));
                    } else {
                            name.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
                    }

            }
            return name.toString().trim(); // Eliminar espacios al inicio o al final
    }
    /**
     * Method to GenerateCardsSeeder with
     * @param quantity to count cards
     * @param typeList to define type (only skill)
     * @param preccenseList to define preccense
     */
    public void GenerateCards(int quantity, List<CardType> typeList, List<Preccense> preccenseList){

            String name;
            int level;
            String description;
            int indexPreccense;
            long indexPreccenseID;
            Preccense preccense;
            Card cardGenerated;
            int EntityOrSkill;
            for (int i = 0; i < quantity; i++) {
                    //the name generated
                    name = RandomName(RandomNumbers(2, 20));
                    //the level generated
                    level = RandomNumbers(1, 5);
                    //the description generated
                    description = RandomName(RandomNumbers(10, 40)) + ".";
                    //the preccenseList's quantity
                    indexPreccense = RandomNumbers(0, preccenseList.size() - 1);
                    indexPreccenseID = indexPreccense + 1;
                    preccense = preccenseList.get(indexPreccense);

                    //generate Card
                    cardGenerated = CardBuilder.build(name, level, description, false, indexPreccenseID, preccense);

                    //cardtypeRandom
                    EntityOrSkill = RandomNumbers(1,2);

                    switch (EntityOrSkill) {
                            case 1:
                                    GenerateEntityCards(cardGenerated);
                                    break;
                            case 2:
                                    GenerateSkillCards(cardGenerated, typeList);
                                    break;
                            default:
                                    System.out.println("no hay otro tipo de carta");
                                    break;

                    }
            }
    }

    /**
     * Method to GenerateCardsSeeder with
     * @param card to card as empty
     */
    public void GenerateEntityCards(Card card){
            //entityCards atributtes
            int physicalPower = RandomNumbers(0, 50);
            int magicalPower = RandomNumbers(0, 50);
            int physicalProtection = RandomNumbers(0, 40);
            int magicalProtection = RandomNumbers(0, 40);
            EntityCard entityCard = EntityCardBuilder.build(card, physicalPower, magicalPower, physicalProtection, magicalProtection);
            this.cardRepository.addEntityCardSeeder(entityCard);
    }

    /**
     * Method to GenerateCardsSeeder with
     * @param card to card as empty
     * @param typeList use assign to skillCard
     */
    public void GenerateSkillCards(Card card, List<CardType> typeList){
            //skillCards atributtes
            int power = RandomNumbers(0, 30);
            //the typeList's quantity
            int indexType = RandomNumbers(0, typeList.size() - 1);
            long indexTypeID = indexType + 1;
            CardType cardType = typeList.get(indexType);
            SkillCard skillCard = SkillCardBuilder.build(card, power, indexTypeID, cardType);
            this.cardRepository.addSkillCardSeeder(skillCard);
    }
}
