package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.Interfaces.ICardRepository;
import org.example.Models.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    private final ICardRepository cardRepository;

    public CardController(Javalin app, ICardRepository cardRepository) {
        super(app);
        this.cardRepository = cardRepository;
    }

    @Override
    protected void configureRoutes() {
        app.get("/Cards", this::getAllCards);
        app.get("/Cards/presence/{preccenseID}", this::getCardsByPreccense);
        app.get("/Cards/{id}", this::getCardById);
        app.get("/Cards/nombre/{name}", this::getCardByName);
        app.post("/Cards/entity", this::addEntityCard);
        app.post("/Cards/skill", this::addSkillCard);
        app.delete("/Cards/{id}", this::deleteCard);
    }

    private void getAllCards(Context ctx) {
        ctx.json(cardRepository.getCards());
    }

    private void getCardsByPreccense(Context ctx) {
        String preccenseIDStr = ctx.pathParam("preccenseID");
        Long preccenseID = Long.parseLong(preccenseIDStr);
        ctx.json(cardRepository.getCardsByPreccense(preccenseID));
    }

    private void getCardById(Context ctx) {
        String cardIdStr = ctx.pathParam("id");
        Long cardId = Long.parseLong(cardIdStr);
        ctx.json(cardRepository.getCardById(cardId));
    }

    private void getCardByName(Context ctx) {
        String name = ctx.pathParam("name");
        log.debug("Card name: {}", name);
        if (name.isEmpty()) {
            respondWithError(ctx, 400, "El parámetro 'name' no puede estar vacío.");
            return;
        }
        Card card = cardRepository.Find(name);
        if (card == null) {
            respondWithError(ctx, 404, "No se encontró ninguna carta con el nombre: " + name);
        } else {
            ctx.json(card);
        }
    }

    private void addEntityCard(Context ctx) {
        AddEntityCardDTO dto = ctx.bodyAsClass(AddEntityCardDTO.class);
        cardRepository.addEntityCard(dto);
        ctx.status(201);
    }

    private void addSkillCard(Context ctx) {
        AddSkillCardDTO dto = ctx.bodyAsClass(AddSkillCardDTO.class);
        cardRepository.addSkillCard(dto);
        ctx.status(201);
    }

    private void deleteCard(Context ctx) {
        String cardIdStr = ctx.pathParam("id");
        Long cardId = Long.parseLong(cardIdStr);
        boolean isDeleted = cardRepository.deleteCard(cardId);
        if (isDeleted) {
            ctx.result("Tarjeta eliminada correctamente");
            ctx.status(200);
        } else {
            respondWithError(ctx, 404, "Ya está eliminada la tarjeta");
        }
    }
}
