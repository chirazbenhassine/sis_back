package com.projet.securite.api.controller;

import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.service.RondService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rond")
public class RondController {
    private RondService rondService;

    public RondController(RondService rondService) {

        this.rondService = rondService;
    }


    @PostMapping()
    public ResponseEntity<Ronds> saveRond(@RequestBody Ronds ronds){
        return new ResponseEntity<Ronds>(rondService.saveRond(ronds), HttpStatus.CREATED);
    }
    //build all get ronds REST API
    @GetMapping
    public List<Ronds> getAllRonds(){
        return rondService.getAllRonds();
    }
    //build get rond by Id REST API
    //http://localhost:8080/api/rond/1
    @GetMapping("{id}")
    public ResponseEntity<Ronds> getRondById(@PathVariable("id") Long rondId){
        return new ResponseEntity<Ronds>(rondService.getRondById(rondId),HttpStatus.OK);
    }
    //build Update rond  REST API
    //http://localhost:8080/api/rond/1
    @PutMapping("{id}")
    public ResponseEntity<Ronds> updateRond(@PathVariable("id") Long rondId,
                                           @RequestBody Ronds ronds){
        return new ResponseEntity<Ronds>(rondService.updateRond(ronds,rondId),HttpStatus.OK);
    }

    // build Delete rond REST API
    //http://localhost:8080/api/rond/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSite(@PathVariable("id") Long rondId){
        //delete Site from DB
        rondService.deleteRond(rondId);
        return  new ResponseEntity<String>("Rond deleted successfully",HttpStatus.OK);
    }

}
