package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.Helpers.Mapper;

public abstract class BaseController {

    protected final Javalin app;

    public BaseController(Javalin app) {
        this.app = app;
        configureRoutes();
    }

    protected abstract void configureRoutes();

    protected void respondWithError(Context ctx, int statusCode, String message) {
        ctx.status(statusCode);
        ctx.json(message);
    }
}
