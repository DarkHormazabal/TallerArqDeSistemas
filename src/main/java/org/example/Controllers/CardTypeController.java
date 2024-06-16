package org.example.Controllers;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.DTO.CardDTO.CardTypeDTO;
import org.example.Helpers.Mapper;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Specific.CardType;

import java.util.List;

public class CardTypeController extends BaseController{

    private final ITypeRepository typeRepository;

    public CardTypeController(Javalin app, ITypeRepository typeRepository) {
        super(app);
        this.typeRepository = typeRepository;
    }

    @Override
    protected void configureRoutes() {
        app.get("/CardTypes", this::getAllCardTypes);
        app.get("/CardTypes/{id}", this::getCardTypesById);
    }

    private void getAllCardTypes(Context ctx) {
        List<CardType> cardTypes = typeRepository.getCardTypes();
        List<CardTypeDTO> cardTypeDTOList = Mapper.toCardTypeDTOList(cardTypes);
        ctx.json(cardTypeDTOList);
    }

    private void getCardTypesById(Context ctx) {
        String cardTypeIdStr = ctx.pathParam("id");
        Long cardTypeId = Long.parseLong(cardTypeIdStr);
        CardType cardType = typeRepository.getTypeSkillCardById(cardTypeId);
        if (cardType == null) {
            ctx.status(404);
        }
        CardTypeDTO cardTypeDTO = Mapper.toCardTypeDTO(cardType);
        ctx.json(cardTypeDTO);
    }


}
