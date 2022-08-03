package com.projet.securite.api.service;

import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;

import java.util.List;

public interface RondService {
    Ronds saveRond(Ronds ronds); //POST
    List<Ronds> getAllRonds(); //GET
    Ronds getRondById(Long id); // GET BY ID
    Ronds updateRond(Ronds ronds, Long id); //UPDATE
    void deleteRond(Long id);
    //void addPointeauToRond(String RondName, String PointeauName);
}
