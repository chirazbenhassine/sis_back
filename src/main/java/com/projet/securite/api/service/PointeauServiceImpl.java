package com.projet.securite.api.service;

import com.projet.securite.api.exception.RessourceNotFoundException;
import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.repository.PointeauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class PointeauServiceImpl implements  PointeauService{

    private final PointeauRepository pointeauRepository;

    @Override
    public Pointeau savePointeau(Pointeau pointeau) {
        return pointeauRepository.save(pointeau);
    }

    @Override
    public List<Pointeau> getAllPointeaux() {
         return pointeauRepository.findAll();
    }

    @Override
    public Pointeau getPointeauById(Long id) {
        Optional<Pointeau> Pointeau = pointeauRepository.findById(id);
        /*if (pointeau.isPresent()){
           return rond.get();
        }else{
            throw new RessourceNotFoundException("Pointeau","Id",id);
        }*/
        return pointeauRepository.findById(id).orElseThrow(()-> new RessourceNotFoundException("Pointeau","Id", id));
    }

    @Override
    public Pointeau updatePointeau(Pointeau pointeau, Long id) {
        //need to check if pointeau  with given id is exist in DB or not
        Pointeau existingPointeau = pointeauRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Pointeau","Id", id));
        String name = pointeau.getName();
        if (name != null && name != ""){
            existingPointeau.setName(pointeau.getName());
        }

        //Save in DB
        pointeauRepository.save(existingPointeau);
        return existingPointeau;
    }

   @Override
    public void deletePoiteau(Long id) {
        //Check if pointeau exist with given id  is exist in DB
        Pointeau  existingPointeau = pointeauRepository.findById(id).orElseThrow( ()-> new RessourceNotFoundException("Pointeau","Id", id));
        pointeauRepository.deleteById(id);

    }
}
