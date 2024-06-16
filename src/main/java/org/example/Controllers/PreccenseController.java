package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.DTO.CardDTO.PreccenseDTO;
import org.example.Helpers.Mapper;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Specific.Preccense;

import java.util.ArrayList;
import java.util.List;

public class PreccenseController extends BaseController {

    private final IPreccenseRepository preccenseRepository;

    //private static final Mapper mapper = new Mapper();

    public PreccenseController(Javalin app, IPreccenseRepository preccenseRepository) {
        super(app);
        this.preccenseRepository = preccenseRepository;
    }

    @Override
    protected void configureRoutes() {
        app.get("/Preccenses", this::getAllPreccenses);
        app.get("/Preccenses/{id}", this::getPreccensesById);
    }

    private void getAllPreccenses(Context ctx) {
        List<Preccense> preccenseList = preccenseRepository.getPreccenses();
        List<PreccenseDTO> preccenseDTOList = Mapper.toPreccenseDTOList(preccenseList);
        ctx.json(preccenseDTOList);
    }

    private void getPreccensesById(Context ctx) {
        String preccenseIdStr = ctx.pathParam("id");
        Long preccenseId = Long.parseLong(preccenseIdStr);
        Preccense preccense = preccenseRepository.getPreccenseById(preccenseId);
        if (preccense == null) {
            ctx.status(404);
        }
        PreccenseDTO preccenseDTO = Mapper.toPreccenseDTO(preccense);
        ctx.json(preccenseDTO);
    }

}
