package org.example.Seeders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Database;
import lombok.AllArgsConstructor;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Builders.*;
import org.example.Models.Card;
import org.example.Models.Specific.CardType;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.Preccense;
import org.example.Models.Specific.SkillCard;
import org.example.Services.TypeRepository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
public class Seed {

    private ICardRepository cardRepository;

    private IPreccenseRepository preccenseRepository;

    private ITypeRepository typeRepository;


    public void Seeders() throws IOException {


            // Crear un ObjectMapper (parte de Jackson)
            ObjectMapper objectMapper = new ObjectMapper();

            // Leer el archivo JSON y mapearlo a una lista de objetos User
            File file = new File("TypesCard.JSON");
            List<CardType> typeList = objectMapper.readValue(file, new TypeReference<>(){});

            // Iterar sobre la lista de usuarios y imprimir sus atributos
            this.typeRepository.addTypeSkillCard(typeList);

            File file2 = new File("Preccenses.JSON");
            List<Preccense> preccenseList = objectMapper.readValue(file2, new TypeReference<>(){});
            this.preccenseRepository.addPreccenseCard(preccenseList);


            File file3 = new File("EntityCards.JSON");
            List<EntityCard> entityCardList = objectMapper.readValue(file3, new TypeReference<>(){});

            for (EntityCard entityCard : entityCardList) {
                this.cardRepository.addEntityCardSeeder(entityCard);
            }

            File file4 = new File("SkillCards.JSON");
            List<SkillCard> skillCardList = objectMapper.readValue(file4, new TypeReference<>(){});
            for (SkillCard skillCard : skillCardList) {
                this.cardRepository.addEntityCardSeeder(skillCard);
            }

    }




}
