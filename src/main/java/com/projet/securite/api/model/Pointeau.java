package com.projet.securite.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Pointeau")
public class Pointeau {
    @Id //specifies to primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_de_pointeaux", nullable = false)
    private String nomPointeau;
}
