package com.projet.securite.api.service;

import com.projet.securite.api.exception.RessourceNotFoundException;
import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.repository.PointeauRepository;
import com.projet.securite.api.repository.RondRepository;
import com.projet.securite.api.repository.SiteRepository;
import com.projet.securite.authUser.model.Role;
import com.projet.securite.authUser.model.User;
import com.projet.securite.authUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RondServiceImpl implements RondService{


    private final RondRepository rondRepository;
    private  final PointeauRepository pointeauRepository;



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

   /*@Override
   public Ronds getRond(String name) {
       Optional<Ronds> rond = rondRepository.findById(name);

       return rondRepository.findByName(name).orElseThrow(()-> new RessourceNotFoundException("Rond","name", name));
    }*/

    @Override
    public Ronds updateRond(Ronds ronds, Long id) {
        //need to check if site  with given id is exist in DB or not
        Ronds existingRond = rondRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Rond","Id", id));

        existingRond.setName(ronds.getName());

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

    @Override
    public void addPointeauToRond(Long idRond, Long idPointeau) {
        Ronds rond = rondRepository.findOneById(idRond);
        Pointeau pointeau= pointeauRepository.findOneById(idPointeau);
            rond.getPointeaux().add(pointeau);
    }
}
