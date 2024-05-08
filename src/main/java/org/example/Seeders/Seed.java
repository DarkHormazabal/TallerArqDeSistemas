package org.example.Seeders;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Database;
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

@AllArgsConstructor
public class Seed {

    private ICardRepository cardRepository;

    private IPreccenseRepository preccenseRepository;

    private ITypeRepository typeRepository;

    private static String path = "C:/Users/56949/IdeaProjects/TallerDeArqDeSistemas/src/main/java/org/example/Seeders/JSONFiles/";

    private static final Logger log = LoggerFactory.getLogger(Seed.class);

    public void Seeders() {

            //skilcard's type
            CardType type1 = CardTypeBuilder.build("Physical");
            CardType type2 = CardTypeBuilder.build("Magical");
            this.typeRepository.addTypeSkillCard(type1);
            this.typeRepository.addTypeSkillCard(type2);

            //pressences's card type
            Preccense preccense1 = PreccenseBuilder.build("Fuego", "Rojo");
            this.preccenseRepository.addPreccenseCard(preccense1);
            Preccense preccense2 = PreccenseBuilder.build("Tierra", "Verde");
            this.preccenseRepository.addPreccenseCard(preccense2);
            Preccense preccense3 = PreccenseBuilder.build("Aire", "Morado");
            this.preccenseRepository.addPreccenseCard(preccense3);
            Preccense preccense4 = PreccenseBuilder.build("Agua", "Azul");
            this.preccenseRepository.addPreccenseCard(preccense4);
            Preccense preccense5 = PreccenseBuilder.build("Éter", "Amarillo");
            this.preccenseRepository.addPreccenseCard(preccense5);
            Preccense preccense6 = PreccenseBuilder.build("Santo", "Blanco");
            this.preccenseRepository.addPreccenseCard(preccense6);
            Preccense preccense7 = PreccenseBuilder.build("Destrucción", "Gris Oscuro");
            this.preccenseRepository.addPreccenseCard(preccense7);

            //cards seeders
            //entitiesCards
            Card card1 = CardBuilder.build("Bola de Fuego", 1, "Conjura una esfera ardiente que inflige daño a un enemigo.",
                    false, 6L, preccense3);
            EntityCard entityCard1 = EntityCardBuilder.build(card1, 0, 15, 3, 1);
            this.cardRepository.addEntityCardSeeder(entityCard1);

            Card card2 = CardBuilder.build("Inferno", 2, "Invoca un muro de llamas que daña a todos los enemigos.",
                    false, 3L, preccense2);
            EntityCard entityCard2 = EntityCardBuilder.build(card2, 0, 20, 0, 5);
            this.cardRepository.addEntityCardSeeder(entityCard2);

            Card card3 = CardBuilder.build("Avalancha", 2, "Desata una avalancha que causa daño y aturde a todos los enemigos.",
                    false, 1L, preccense1);
            EntityCard entityCard3 = EntityCardBuilder.build(card3,  18, 0, 8, 2);
            this.cardRepository.addEntityCardSeeder(entityCard3);

            Card card4 = CardBuilder.build("Viento Cortante", 1, "Crea una ráfaga de viento afilado que corta a los enemigos.",
                    false, 7L, preccense4);
            EntityCard entityCard4 = EntityCardBuilder.build(card4, 12, 0, 5, 2);
            this.cardRepository.addEntityCardSeeder(entityCard4);

            Card card5 = CardBuilder.build("Tormenta Eléctrica", 2, "Invoca una tormenta eléctrica que electrocuta a todos los enemigos.",
                    false, 5L, preccense3);
            EntityCard entityCard5 = EntityCardBuilder.build(card5, 0, 25, 0, 8);
            this.cardRepository.addEntityCardSeeder(entityCard5);

            Card card6 = CardBuilder.build("Marea Curativa", 1, "Invoca una marea curativa que restaura la salud de los aliados.",
                    false, 2L, preccense2);
            EntityCard entityCard6 = EntityCardBuilder.build(card6,  0, 10, 0, 5);
            this.cardRepository.addEntityCardSeeder(entityCard6);

            Card card7 = CardBuilder.build("Lluvia Ácida", 2, "Causa daño a todos los enemigos con una lluvia ácida.",
                    false, 4L, preccense5);
            EntityCard entityCard7 = EntityCardBuilder.build(card7,  0, 18, 0, 3);
            this.cardRepository.addEntityCardSeeder(entityCard7);

            Card card8 = CardBuilder.build("Espadachín de las Llamas", 3, "Un hábil espadachín que maneja una espada ardiente con destreza.",
                    false, 4L, preccense2);
            EntityCard entityCard8 = EntityCardBuilder.build(card8, 20, 5, 15, 5);
            this.cardRepository.addEntityCardSeeder(entityCard8);

            Card card9 = CardBuilder.build("Gigante de Lava", 4, "Una criatura gigantesca formada de lava y fuego que arrasa todo a su paso.",
                    false, 1L, preccense1);
            EntityCard entityCard9 = EntityCardBuilder.build(card9, 30, 10, 25, 10);
            this.cardRepository.addEntityCardSeeder(entityCard9);

            Card card10 = CardBuilder.build("Caballero de la Roca", 3, "Un valiente caballero que lleva una armadura pesada y una espada afilada.",
                    false, 6L, preccense3);
            EntityCard entityCard10 = EntityCardBuilder.build(card10, 25, 0, 20, 10);
            this.cardRepository.addEntityCardSeeder(entityCard10);

            Card card11 = CardBuilder.build("Gólem de Tierra", 4, "Una construcción de piedra animada que defiende su territorio con fuerza bruta.",
                    false, 3L, preccense2);
            EntityCard entityCard11 = EntityCardBuilder.build(card11, 35, 0, 30, 15);
            this.cardRepository.addEntityCardSeeder(entityCard11);

            Card card12 = CardBuilder.build("Bárbaro del Viento", 3, "Un guerrero nómada que surca los cielos montado en un dragón de viento.",
                    false, 2L, preccense1);
            EntityCard entityCard12 = EntityCardBuilder.build(card12, 20, 15, 10, 10);
            this.cardRepository.addEntityCardSeeder(entityCard12);

            Card card13 = CardBuilder.build("Grifo Celestial", 4, "Una bestia alada mítica que domina los cielos con su poderoso pico y garras.",
                    false, 7L, preccense4);
            EntityCard entityCard13 = EntityCardBuilder.build(card13, 30, 20, 15, 15);
            this.cardRepository.addEntityCardSeeder(entityCard13);

            Card card14 = CardBuilder.build("Merodeador del Mar", 3, "Un guerrero que se desliza sobre las olas con su tridente en mano.",
                    false, 5L, preccense3);
            EntityCard entityCard14 = EntityCardBuilder.build(card14, 20, 10, 15, 10);
            this.cardRepository.addEntityCardSeeder(entityCard14);

            Card card15 = CardBuilder.build("Kraken Devorador", 4, "Una bestia marina gigantesca con tentáculos que destrozan barcos enteros.",
                    false, 7L, preccense4);
            EntityCard entityCard15 = EntityCardBuilder.build(card15, 30, 15, 25, 15);
            this.cardRepository.addEntityCardSeeder(entityCard15);

            Card card16 = CardBuilder.build("Mago del Éter", 3, "Un mago que canaliza la energía del éter para lanzar poderosos hechizos.",
                    false, 1L, preccense1);
            EntityCard entityCard16 = EntityCardBuilder.build(card16, 5, 25, 5, 15);
            this.cardRepository.addEntityCardSeeder(entityCard16);

            Card card17 = CardBuilder.build("Némesis Dimensional", 4, "Una entidad misteriosa que viaja a través de dimensiones, desafiando las leyes del espacio.",
                    false, 2L, preccense1);
            EntityCard entityCard17 = EntityCardBuilder.build(card17, 10, 30, 10, 20);
            this.cardRepository.addEntityCardSeeder(entityCard17);

            Card card18 = CardBuilder.build("Paladín Sagrado", 3, "Un guerrero piadoso que lucha con la bendición divina y la fuerza del espíritu.",
                    false, 6L, preccense3);
            EntityCard entityCard18 = EntityCardBuilder.build(card18,20, 10, 20, 10);
            this.cardRepository.addEntityCardSeeder(entityCard18);

            Card card19 = CardBuilder.build("Ángel de la Redención", 4, "Una criatura celestial que desciende para purificar el mundo de la oscuridad.",
                    false, 3L, preccense2);
            EntityCard entityCard19 = EntityCardBuilder.build(card19, 25, 15, 25, 15);
            this.cardRepository.addEntityCardSeeder(entityCard19);

            Card card20 = CardBuilder.build("Devorador de Almas", 3, "Una entidad maligna que consume las almas de sus víctimas para alimentar su poder oscuro.",
                    false, 5L, preccense3);
            EntityCard entityCard20 = EntityCardBuilder.build(card20, 25, 20, 15, 15);
            this.cardRepository.addEntityCardSeeder(entityCard20);

            Card card21 = CardBuilder.build("Cataclismo", 4, "Un evento apocalíptico que desata la destrucción total sobre el mundo.",
                    false, 4L, preccense1);
            EntityCard entityCard21 = EntityCardBuilder.build(card21, 30, 25, 20, 20);
            this.cardRepository.addEntityCardSeeder(entityCard21);

            //SkillCards
            Card card22 = CardBuilder.build("Espada Mágica", 3, "Una espada encantada con magia antigua que aumenta el poder de su portador.",
                    false, 4L, preccense1);
            SkillCard skillCard1 = SkillCardBuilder.build(card22, 35, 1, type1);
            this.cardRepository.addSkillCardSeeder(skillCard1);

            Card card23 = CardBuilder.build("Báculo Arcano", 4, "Un báculo tallado con runas arcanas que amplifica los hechizos de su portador.",
                    false, 4L, preccense1);
            SkillCard skillCard2 = SkillCardBuilder.build(card23, 40, 2, type2);
            this.cardRepository.addSkillCardSeeder(skillCard2);

            Card card24 = CardBuilder.build("Armadura del Dragón", 3, "Una armadura forjada con escamas de dragón que otorga una defensa sobrenatural.",
                    false, 3L, preccense2);
            SkillCard skillCard3 = SkillCardBuilder.build(card24, 25, 1, type1);
            this.cardRepository.addSkillCardSeeder(skillCard3);

            Card card25 = CardBuilder.build("Anillo de la Serpiente", 4, "Un anillo imbuido con el poder de una serpiente mística que incrementa la destreza de su portador.",
                    false, 4L, preccense2);
            SkillCard skillCard4 = SkillCardBuilder.build(card25, 30, 2, type2);
            this.cardRepository.addSkillCardSeeder(skillCard4);

            Card card26 = CardBuilder.build("Espada de Luz", 2, "Una espada imbuida con la energía de la luz que purifica el mal.",
                    false, 2L, preccense3);
            SkillCard skillCard5 = SkillCardBuilder.build(card26, 30, 1, type1);
            this.cardRepository.addSkillCardSeeder(skillCard5);

            Card card27 = CardBuilder.build("Capa de Invisibilidad", 3, "Una capa mágica que otorga a su portador el poder de volverse invisible.",
                    false, 3L, preccense4);
            SkillCard skillCard6 = SkillCardBuilder.build(card27, 25, 2, type2);
            this.cardRepository.addSkillCardSeeder(skillCard6);

            Card card28 = CardBuilder.build("Piedra de Resurrección", 4, "Una piedra mística capaz de revivir a los caídos una vez por batalla.",
                    false, 4L, preccense3);
            SkillCard skillCard7 = SkillCardBuilder.build(card28, 40, 1, type1);
            this.cardRepository.addSkillCardSeeder(skillCard7);

            Card card29 = CardBuilder.build("Amuleto de Protección", 2, "Un amuleto encantado que protege a su portador de los ataques mágicos.",
                    false, 2L, preccense2);
            SkillCard skillCard8 = SkillCardBuilder.build(card29, 20, 2, type2);
            this.cardRepository.addSkillCardSeeder(skillCard8);

    }
}
