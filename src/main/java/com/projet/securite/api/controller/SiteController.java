package com.projet.securite.api.controller;

import com.projet.securite.api.model.Site;
import com.projet.securite.api.service.SiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")

public class SiteController {

    private SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }
    //build create site REST API
    @PostMapping()
    public ResponseEntity<Site> saveSite(@RequestBody Site site){
        return new ResponseEntity<Site>(siteService.saveSite(site), HttpStatus.CREATED);
    }
    //build all get sites REST API
    @GetMapping
    public List<Site> getAllSites(){
        return siteService.getAllSites();
    }
    //build get site by Id REST API
    //http://localhost:8080/api/site/1
    @GetMapping("{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable("id") Long siteId){
        return new ResponseEntity<Site>(siteService.getSiteById(siteId),HttpStatus.OK);
    }
    //build Update site REST API
    //http://localhost:8080/api/site/1
    @PutMapping("{id}")
    public ResponseEntity<Site> updateSite(@PathVariable("id") Long siteId,
                                           @RequestBody Site site){
        return new ResponseEntity<Site>(siteService.updateSite(site,siteId),HttpStatus.OK);
    }

    // build Delete site REST API
    //http://localhost:8080/api/site/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSite(@PathVariable("id") Long siteId){
        //delete Site from DB
    siteService.deleteSite(siteId);
    return  new ResponseEntity<String>("Site deleted successfully",HttpStatus.OK);
    }

}
