package org.example.Services;

import io.ebean.Database;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.Interfaces.IPreccenseRepository;
import org.example.Models.Specific.Preccense;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class PreccenseRepository implements IPreccenseRepository {

    /**
     * The database
     */
    private final Database database;

    /**
     * The preccenses list
     */
    private List<Preccense> preccenses;

    @Override
    public Preccense getPreccenseById(Long id) {
        //find the Preccense
        return database.find(Preccense.class, id);
    }

    @Override
    public void addPreccenseCard(Preccense preccense) {
        this.database.insert(preccense);
    }

    @Override
    public List<Preccense> getPreccenses() {
        return preccenses;
    }
}
