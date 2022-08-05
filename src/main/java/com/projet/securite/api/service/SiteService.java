package com.projet.securite.api.service;

import com.projet.securite.api.model.Site;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface SiteService {
    Site saveSite(Site site); //POST
    List<Site> getAllSites(); //GET
    Site getSiteById(Long id); // GET BY ID
    Site updateSite(Site site, Long id); //UPDATE
    void deleteSite(Long id);
    void addRondToSite(Long idSite, Long idRond);

}
