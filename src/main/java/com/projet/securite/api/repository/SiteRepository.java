package com.projet.securite.api.repository;

import com.projet.securite.api.model.Site;
import com.projet.securite.authUser.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {
  Site findByName(String name);

  Site findOneById(Long id);

}
