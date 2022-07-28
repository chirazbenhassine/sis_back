package com.projet.securite.api.repository;

import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointeauRepository extends JpaRepository<Pointeau, Long> {
}
