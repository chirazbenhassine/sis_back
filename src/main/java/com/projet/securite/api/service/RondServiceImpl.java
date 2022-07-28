package com.projet.securite.api.service;

import com.projet.securite.api.exception.RessourceNotFoundException;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.repository.RondRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RondServiceImpl implements RondService{

    private RondRepository rondRepository;
    public RondServiceImpl(RondRepository rondRepository) {
        super();
        this.rondRepository = rondRepository;
    }

    @Override
    public Ronds saveRond(Ronds ronds) {
        return rondRepository.save(ronds);
    }

    @Override
    public List<Ronds> getAllRonds() {
        return rondRepository.findAll();
    }

    @Override
    public Ronds getRondById(Long id) {
        Optional<Ronds> rond = rondRepository.findById(id);
        /*if(rond.isPresent()){
           return rond.get();
        }else{
            throw new RessourceNotFoundException("Rond","Id",id);
        }*/
        return rondRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Rond","Id", id));
    }

    @Override
    public Ronds updateRond(Ronds ronds, Long id) {
        //need to check if site  with given id is exist in DB or not
        Ronds existingRond = rondRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Rond","Id", id));

        existingRond.setNomRond(ronds.getNomRond());

        //Save in DB
        rondRepository.save(existingRond);
        return existingRond;
    }

    @Override
    public void deleteRond(Long id) {
        //Check if site exist with given id  is exist in DB
        Ronds existingSite = rondRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Site","Id", id));
        rondRepository.deleteById(id);

    }
}
