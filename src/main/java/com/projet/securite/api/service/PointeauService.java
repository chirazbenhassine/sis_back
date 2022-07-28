package com.projet.securite.api.service;

import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;

import java.util.List;

public interface PointeauService {

    Pointeau savePointeau(Pointeau pointeau); //POST
    List<Pointeau> getAllPointeaux(); //GET
    Pointeau getPointeauById(Long id); // GET BY ID
    Pointeau updatePointeau(Pointeau pointeau, Long id); //UPDATE
    void deletePoiteau(Long id);
}
