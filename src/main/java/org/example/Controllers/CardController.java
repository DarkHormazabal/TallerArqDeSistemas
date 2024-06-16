package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.DTO.AddEntityCardDTO;
import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.DTO.CardDTO.EntityCardDTO;
import org.example.DTO.CardDTO.SkillCardDTO;
import org.example.Helpers.Mapper;
import org.example.Interfaces.ICardRepository;
import org.example.Models.Card;
import org.example.Models.Specific.EntityCard;
import org.example.Models.Specific.SkillCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

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
        app.get("/Cards/presence/{preccenseStr}", this::getCardsByPreccense);
        app.get("/Cards/{id}", this::getCardById);
        app.get("/Cards/nombre/{name}", this::getCardByName);
        app.post("/Cards/entity", this::addEntityCard);
        app.post("/Cards/skill", this::addSkillCard);
        app.delete("/Cards/{id}", this::deleteCard);
    }

    private void getAllCards(Context ctx) {
        List<Card> cards = cardRepository.getCards();
        List<CardDTO> cardDTOS = Mapper.toCardDTOList(cards);
        ctx.json(cardDTOS);
    }

    private void getCardsByPreccense(Context ctx) {
        String preccenseStr = ctx.pathParam("preccenseStr");
        log.debug("Preccense name: {}", preccenseStr);
        if (preccenseStr.isEmpty() || preccenseStr.equals(" ")) {
            respondWithError(ctx, 400, "El parámetro 'preccenseStr' no puede estar vacío.");
            return;
        }
        List<Card> cards = cardRepository.getCardsByPreccense(preccenseStr);
        List<CardDTO> cardDTOS = Mapper.toCardDTOList(cards);
        ctx.json(cardDTOS);

    }

    private void getCardById(Context ctx) {
        String cardIdStr = ctx.pathParam("id");
        Long cardId = Long.parseLong(cardIdStr);
        Card card = cardRepository.getCardById(cardId);
        if(card == null) { respondWithError(ctx, 404, "No se encontró ninguna carta con el nombre: " + cardIdStr); }
        CardDTO cardDTO = Mapper.toCardDTO(card);
        ctx.json(cardDTO);
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
            CardDTO cardDTO = Mapper.toCardDTO(card);
            ctx.json(cardDTO);
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
