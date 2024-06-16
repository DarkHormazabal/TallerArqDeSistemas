package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;

public class PreccenseController extends BaseController {

    private final IPreccenseRepository preccenseRepository;

    public PreccenseController(Javalin app, IPreccenseRepository preccenseRepository) {
        super(app);
        this.preccenseRepository = preccenseRepository;
    }

    @Override
    protected void configureRoutes() {
        app.get("/Preccense", this::getAllPreccenses);
        app.get("/Preccense/{id}", this::getPreccensesById);
    }

    private void getAllPreccenses(Context ctx) {
        ctx.json(preccenseRepository.getPreccenses());
    }

    private void getPreccensesById(Context ctx) {
        String preccenseIdStr = ctx.pathParam("id");
        Long preccenseId = Long.parseLong(preccenseIdStr);
        ctx.json(preccenseRepository.getPreccenseById(preccenseId));
    }

}
