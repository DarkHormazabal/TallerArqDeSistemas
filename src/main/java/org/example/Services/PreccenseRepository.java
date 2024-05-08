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
@Getter
@Setter
@AllArgsConstructor
public class PreccenseRepository implements IPreccenseRepository {

    /**
     * The database
     */
    private final Database database;


    @Override
    public Preccense getPreccenseById(Long id) {
        //find the Preccense
        return database.find(Preccense.class, id);
    }

    @Override
    public void addPreccenseCard(List<Preccense> preccenses) {
        this.database.insertAll(preccenses);
    }
}
