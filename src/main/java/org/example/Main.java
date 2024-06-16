package org.example;

import io.javalin.Javalin;
import io.javalin.http.Header;
import io.javalin.http.HttpStatus;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.bundled.RouteOverviewPlugin;
import lombok.extern.slf4j.Slf4j;
import io.ebean.DB;
import io.ebean.Database;
import org.example.Controllers.CardController;
import org.example.Controllers.CardTypeController;
import org.example.Controllers.PreccenseController;
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

    public static Javalin createAndConfigureJavalin(CardRepository cardRepository,
                                                    PreccenseRepository preccenseRepository,
                                                    TypeRepository typeRepository) {
        Javalin app = Javalin.create(config -> {
            // Configuraciones adicionales, si las hay

        });

        // Configuración de CORS manualmente
        app.options("/*", ctx -> {
            String accessControlRequestHeaders = ctx.header("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                ctx.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = ctx.header("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                ctx.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            ctx.status(200);
        });

        app.before(ctx -> {
            ctx.header("Access-Control-Allow-Origin", "*");
            ctx.header("Access-Control-Allow-Credentials", "true");
        });

        // Registrar controlador de tarjetas
        new CardController(app, cardRepository);
        new PreccenseController(app, preccenseRepository);
        new CardTypeController(app, typeRepository);

        app.get("/salir", ctx -> {
            ctx.result("Servidor detenido");
            app.stop();
        });

        return app;
    }

    public static Javalin start(final int port, CardRepository cardRepository,
                                PreccenseRepository preccenseRepository, TypeRepository typeRepository){

        if (port < 1024 || port > 65535){

            log.error("Bad port {}.", port);
            throw new IllegalArgumentException("Bad port: " + port);

        }
        log.debug("Starting api rest server in port {} ..", port);

        //the server
        Javalin app = createAndConfigureJavalin(cardRepository, preccenseRepository, typeRepository);


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
        Javalin app = start(2026, cardRepository, preccenseRepository, typeRepository);




        /**Esto apunta al puerto, es similar a los controladores de software donde utiliza un http y con esa
         * peticion obtiene el resultado*/



        /**
         log.debug("Stopping...");

         app.stop();

         log.debug("Done. ^^");
         */
    }

}