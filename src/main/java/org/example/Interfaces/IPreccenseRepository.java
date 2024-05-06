package org.example.Interfaces;

import org.example.DTO.AddSkillCardDTO;
import org.example.DTO.CardDTO.CardDTO;
import org.example.Models.Card;
import org.example.Models.Specific.Preccense;

public interface IPreccenseRepository {

    /**
     * @return
     * @param id to view
     * find preccense by id
     */
    public Preccense getPreccenseById(Long id);

    public Preccense addPreccenseCard(Preccense preccense);

}
