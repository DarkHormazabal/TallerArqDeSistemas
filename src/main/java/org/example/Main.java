package org.example;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import io.ebean.DB;
import io.ebean.Database;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.Interfaces.ICardRepository;
import org.example.Models.Card;
import org.example.Seeders.Seed;
import org.example.Services.CardRepository;
import org.example.Services.PreccenseRepository;
import org.example.Services.TypeRepository;

import java.io.IOException;
import java.util.LinkedList;

/**
 * The Main
 *
 * @autor Matias orellana
 */

@Slf4j //simple login faltale for java, nos injecta un atributo del logger
//entrega mucho mas imformacion que el system.out.print ln
//nombre de la clase
//la hora, todo
public class Main {

    public static Javalin createAndConfigureJavalin(CardRepository cardRepository) {
        Javalin app = Javalin.create();

        // Configuraciones adicionales después de la creación de la instancia
        app.before(ctx -> {
            // Lógica para ejecutar antes de manejar cada solicitud
        });

        app.after(ctx -> {
            // Lógica para ejecutar después de manejar cada solicitud
        });

        app.get("/salir", ctx -> {

            log.debug("Stopping...");

            app.stop();

            log.debug("Done. ^^");
        });

        app.get("/Cards", ctx -> {

            ctx.json(cardRepository.getCards());

        });

        app.get("/Cards/presence/{preccenseID}", ctx -> {
            // Obtener el valor del parámetro "preccenseID" de la URL
            Long preccenseID = Long.parseLong(ctx.pathParam("preccenseID"));

            // Llamar a cardRepository.getCardsByPreccense con el preccenseID
            ctx.json(cardRepository.getCardsByPreccense(preccenseID));
        });

        app.get("/Cards/{id}", ctx -> {

            // Llamar a cardRepository.getCardsByPreccense con el preccenseID
            ctx.json(cardRepository.getCardById(Long.parseLong(ctx.pathParam("id"))));
        });

        app.get("/Cards/nombre/{name}", ctx -> {

            String name = ctx.pathParam("name");
            log.debug("Card name: {}", name);
            if (name.isEmpty()) {
                ctx.status(400); // Bad Request if the param is empty o null
                ctx.json("El parámetro 'name' no puede estar vacío.");
                return;
            }
            Card card = cardRepository.Find(name);

            if (card == null) {
                ctx.status(404); // Not Found si no se encuentra ninguna carta con ese nombre
                ctx.json("No se encontró ninguna carta con el nombre: " + name);
            } else {
                ctx.json(card); // Devolver la carta encontrada como JSON
            }
        });

        app.post("/Cards/entity", ctx -> {
            // Parsear el cuerpo de la solicitud a un objeto AddEntityCardDTO
            AddEntityCardDTO dto = ctx.bodyAsClass(AddEntityCardDTO.class);

            // Llamar a cardRepository.addEntityCard con el objeto dto
            cardRepository.addEntityCard(dto);

            // Responder con un código de estado apropiado, por ejemplo 201 para Created
            ctx.status(201);
        });

        app.post("/Cards/skill", ctx -> {
            // Parsear el cuerpo de la solicitud a un objeto AddSkillCardDTO
            AddSkillCardDTO dto = ctx.bodyAsClass(AddSkillCardDTO.class);

            // Llamar a cardRepository.addSkillCard con el objeto dto
            cardRepository.addSkillCard(dto);

            // Responder con un código de estado apropiado, por ejemplo 201 para Created
            ctx.status(201);
        });


        app.delete("/Cards/{id}", ctx -> {
            // Obtener el ID de la tarjeta de la URL y convertirlo a tipo Long
            Long cardId = Long.parseLong(ctx.pathParam("id"));

            // Intentar eliminar la tarjeta y obtener el resultado
            boolean isDeleted = cardRepository.deleteCard(cardId);

            // Verificar si la tarjeta se eliminó correctamente
            if (isDeleted) {
                // Responder con un mensaje indicando que la tarjeta se eliminó
                ctx.result("Tarjeta eliminada correctamente");
                // Opcionalmente, puedes responder con un código de estado 204 (No Content)
                ctx.status(204);
            } else {
                // Si la tarjeta no se pudo eliminar, responder con un mensaje de error
                ctx.result("No se pudo eliminar la tarjeta");
                // Opcionalmente, puedes responder con un código de estado 404 (Not Found)
                ctx.status(404);
            }
        });

        // Define tus rutas y manejadores aquí utilizando app.get(), app.post(), etc.

        return app;
    }

    public static Javalin start(final int port, CardRepository cardRepository){

        if (port < 1024 || port > 65535){

            log.error("Bad port {}.", port);
            throw new IllegalArgumentException("Bad port: " + port);

        }
        log.debug("Starting api rest server in port {} ..", port);

        //the server
        Javalin app = createAndConfigureJavalin(cardRepository);


        //the hookup thread
        Runtime.getRuntime().addShutdownHook(new Thread(app::stop));

        //hooks to detect the shutdown
        app.events(eventConfig -> {
            eventConfig.serverStarting(() -> {
                log.debug("Starting the javalin server ..");
            });
            eventConfig.serverStarted(() -> {
                log.debug("Server started!");
            });
            eventConfig.serverStopping(() -> {
                log.debug("Stopping the server ..");
            });
            eventConfig.serverStopped(() -> {
                log.debug("Server stopped!");
            });
        });

        //starting
        return app.start(port);
    }


    public static void main(String[] args) {

        log.debug("starting main...");

        log.debug("loading the database...");

        Database db = DB.getDefault();//crea la base de datos

        PreccenseRepository preccenseRepository = new PreccenseRepository(db, new LinkedList<>());

        TypeRepository typeRepository = new TypeRepository(db, new LinkedList<>());

        CardRepository cardRepository = new CardRepository(new LinkedList<>(), db, preccenseRepository, typeRepository);



        /**cargan los seeders*/
        Seed seeders = new Seed(cardRepository, preccenseRepository, typeRepository);
        seeders.Seeders();

        log.debug("loaded the database...");
        log.debug("Beginning app...");


        /**are as controllers*/
        Javalin app = start(2026, cardRepository);




        /**Esto apunta al puerto, es similar a los controladores de software donde utiliza un http y con esa
         * peticion obtiene el resultado*/



        /**
         log.debug("Stopping...");

         app.stop();

         log.debug("Done. ^^");
         */
    }

}