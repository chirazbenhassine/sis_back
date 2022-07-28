package com.projet.securite.api.controller;

import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.service.PointeauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pointeau")
public class PointeauController {
    private PointeauService pointeauService;

    public PointeauController(PointeauService pointeauService) {
        this.pointeauService = pointeauService;
    }

    @PostMapping()
    public ResponseEntity<Pointeau> savePointeau(@RequestBody Pointeau pointeau){
        return new ResponseEntity<Pointeau>(pointeauService.savePointeau(pointeau), HttpStatus.CREATED);
    }
    //build all get pointeau REST API
    @GetMapping
    public List<Pointeau> getAllPointeau(){
        return pointeauService.getAllPointeaux();
    }
    //build get Pointeau by Id REST API
    //http://localhost:8080/api/pointeau/1
    @GetMapping("{id}")
    public ResponseEntity<Pointeau> getPointeauById(@PathVariable("id") Long pointeauId){
        return new ResponseEntity<Pointeau>(pointeauService.getPointeauById(pointeauId),HttpStatus.OK);
    }
    //build Update Pointeau  REST API
    //http://localhost:8080/api/pointeau/1
    @PutMapping("{id}")
    public ResponseEntity<Pointeau> updatePointeau(@PathVariable("id") Long pointeauId,
                                            @RequestBody Pointeau pointeau){
        return new ResponseEntity<Pointeau>(pointeauService.updatePointeau(pointeau,pointeauId),HttpStatus.OK);
    }

    // build Delete Pointeau REST API
    //http://localhost:8080/api/ointeau/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSite(@PathVariable("id") Long pointeauId){
        //delete Pointeau from DB
        pointeauService.deletePoiteau(pointeauId);
        return  new ResponseEntity<String>("Pointeau deleted successfully",HttpStatus.OK);
    }
}
