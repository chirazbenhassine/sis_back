package com.projet.securite.api.service;

import com.projet.securite.api.exception.RessourceNotFoundException;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.repository.RondRepository;
import com.projet.securite.api.repository.SiteRepository;
import com.projet.securite.authUser.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional


public class SiteServiceImpl implements  SiteService{

    private final SiteRepository siteRepository;
    private final RondRepository rondRepository;


    @Override
    public Site saveSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site getSiteById(Long id) {
        Optional<Site> site =siteRepository.findById(id);
        /*if(site.isPresent()){
           return site.get();
        }else{
            throw new RessourceNotFoundException("Site","Id",id);
        }*/
        return siteRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Site","Id", id));
    }

    @Override
    public Site updateSite(Site site, Long id) {
        //need to check if site  with given id is exist in DB or not
        Site existingSite = siteRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Site","Id", id));

        String name = site.getName();
        String adresse = site.getAdresse();
        if(name != null && name != "") {
            existingSite.setName(site.getName());
        }

        if(adresse != null && adresse != "") {
            existingSite.setAdresse(site.getAdresse());
        }

        //Save in DB
        siteRepository.save(existingSite);
        return existingSite;
    }

    @Override
    public void deleteSite(Long id) {
        //Check if site exist with given id  is exist in DB
        Site existingSite = siteRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Site","Id", id));
        siteRepository.deleteById(id);
    }

    @Override
    public void addRondToSite(Long idSite, Long idRond) {
        Site site= siteRepository.findOneById(idSite);
        Ronds rond=rondRepository.findOneById(idRond);
        site.getRonds().add(rond);
    }


}
