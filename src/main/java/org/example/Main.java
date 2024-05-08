package org.example;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import org.example.Controllers.CardController;
import org.example.Seeders.Seed;
import org.example.Services.CardRepository;
import org.example.Services.PreccenseRepository;
import io.ebean.DB;
import io.ebean.Database;

import java.io.IOException;

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

    public static Javalin createAndConfigureJavalin(CardController cardController) {
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

        // Define tus rutas y manejadores aquí utilizando app.get(), app.post(), etc.

        return app;
    }

    public static Javalin start(final int port, CardController cardController){

        if (port < 1024 || port > 65535){

            log.error("Bad port {}.", port);
            throw new IllegalArgumentException("Bad port: " + port);

        }
        log.debug("Starting api rest server in port {} ..", port);

        //the server
        Javalin app = createAndConfigureJavalin(cardController);


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

        CardController cardController = new CardController(db);
        try {
            cardController.LoadSeeders();

        } catch (IOException e){
            log.error("Error loading seeders.");
        }


        /**Esto apunta al puerto, es similar a los controladores de software donde utiliza un http y con esa
         * peticion obtiene el resultado*/

        log.debug("Beginning app...");


        /**are as controllers*/
        Javalin app = start(2026, cardController);

        /**
         log.debug("Stopping...");

         app.stop();

         log.debug("Done. ^^");
         */
    }

}