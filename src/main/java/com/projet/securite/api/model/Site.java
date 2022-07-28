package com.projet.securite.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Site")
public class Site {
    @Id //specifies to primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_de_site", nullable = false)
    private String nomSite;
    @Column(name = "adresse_de_site")
    private String adresse;
}
