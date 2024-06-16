package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.ITypeRepository;

public class CardTypeController extends BaseController{

    private final ITypeRepository typeRepository;

    public CardTypeController(Javalin app, ITypeRepository typeRepository) {
        super(app);
        this.typeRepository = typeRepository;
    }

    @Override
    protected void configureRoutes() {
        app.get("/CardType", this::getAllCardTypes);
        app.get("/CardType/{id}", this::getCardTypesById);
    }

    private void getAllCardTypes(Context ctx) {
        ctx.json(typeRepository.getCardTypes());
    }

    private void getCardTypesById(Context ctx) {
        String cardTypeIdStr = ctx.pathParam("id");
        Long cardTypeId = Long.parseLong(cardTypeIdStr);
        ctx.json(typeRepository.getTypeSkillCardById(cardTypeId));
    }


}
