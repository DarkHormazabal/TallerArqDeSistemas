package org.example;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import io.ebean.DB;
import io.ebean.Database;
import org.example.Interfaces.ICardRepository;
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

        app.get("/Cards/{preccenseID}", ctx -> {
            // Obtener el valor del parámetro "preccenseID" de la URL
            Long preccenseID = Long.parseLong(ctx.pathParam("preccenseID"));

            // Llamar a cardRepository.getCardsByPreccense con el preccenseID
            ctx.json(cardRepository.getCardsByPreccense(preccenseID));
        });

        app.post("/Cards", ctx -> {

        });

        app.put("/Cards/id", ctx -> {

        });

        app.delete("/Cards/id", ctx -> {

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

        PreccenseRepository preccenseRepository = new PreccenseRepository(db);

        TypeRepository typeRepository = new TypeRepository(db);

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