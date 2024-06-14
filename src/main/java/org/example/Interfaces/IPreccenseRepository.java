package org.example.Interfaces;

import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.Models.Card;
import org.example.Models.Specific.Preccense;

import java.util.List;

public interface IPreccenseRepository {

    /**
     * @return
     * @param id to view
     * find preccense by id
     */
    public Preccense getPreccenseById(Long id);

    public void addPreccenseCard(Preccense preccense);

    public List<Preccense> getPreccenses();

}
