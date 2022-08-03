package com.projet.securite.api.repository;

import com.projet.securite.api.model.Pointeau;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PointeauRepository extends JpaRepository<Pointeau, Long> {
    Pointeau findByName(String name);

}
