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

    /**
     * @return
     * @param Name to view
     * find preccense by id
     */
    public Preccense getPreccenseByName(String Name);

    /**
     * Method to addTypePreccenseCard with
     * @param preccense
     */
    public void addPreccenseCard(Preccense preccense);

    /**
     * Method to addTypeSkillCard with
     * @return a List<Preccense>
     */
    public List<Preccense> getPreccenses();

}
