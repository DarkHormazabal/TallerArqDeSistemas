package org.example.Services;

import io.ebean.Database;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Models.Specific.Preccense;

import java.util.List;

@Slf4j
@Getter
@Setter
public class PreccenseRepository implements IPreccenseRepository {

    /**
     * The database
     */
    private final Database database;

    /**
     * The preccense's list
     */
    private List<Preccense> preccenses;

    public PreccenseRepository(Database database) {
        this.database = database;
    }

    @Override
    public Preccense getPreccenseById(Long id) {
        //find the Preccense
        return database.find(Preccense.class, id);
    }
}
