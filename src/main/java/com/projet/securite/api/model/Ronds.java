package com.projet.securite.api.model;

import com.projet.securite.authUser.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Rond")
public class Ronds {
        @Id //specifies to primary key of the entity
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "nom_de_rond", nullable = false)
        private String nomRond;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="rond_fk",referencedColumnName = "id")
        List<Site> sites = new ArrayList<>();

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="rond_fk",referencedColumnName = "id")
        List<Pointeau> pointeaux = new ArrayList<>();

    }

