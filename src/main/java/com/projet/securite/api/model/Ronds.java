package com.projet.securite.api.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="Rond")
public class Ronds {
        @Id //specifies to primary key of the entity
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "nom_de_rond", nullable = false)
        private String nomRond;

    }

