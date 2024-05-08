package org.example.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Database;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Interfaces.ICardRepository;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Interfaces.ITypeRepository;
import org.example.Models.Card;
import org.example.Seeders.Seed;
import org.example.Services.CardRepository;
import org.example.Services.PreccenseRepository;
import org.example.Services.TypeRepository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class CardController {

    private ICardRepository cardRepository;

    private IPreccenseRepository preccenseRepository;

    private ITypeRepository typeRepository;

    private Database DB;

    public CardController(Database DB) {
        this.DB = DB;
        this.preccenseRepository = new PreccenseRepository(DB);
        this.typeRepository = new TypeRepository(DB);
        this.cardRepository = new CardRepository(new LinkedList<>(),DB, this.preccenseRepository, this.typeRepository);
    }

    public void LoadSeeders() throws IOException {
        /**cargan los seeders*/
        Seed seeders = new Seed(cardRepository,preccenseRepository,typeRepository);
        seeders.Seeders();

        log.debug("loaded the database...");
    }


}
