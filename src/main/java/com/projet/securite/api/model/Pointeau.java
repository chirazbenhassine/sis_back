package com.projet.securite.api.model;

import com.projet.securite.authUser.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Pointeau")
public class Pointeau {
    @Id //specifies to primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_de_pointeaux", nullable = false)
    private String nomPointeau;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pointeau_fk",referencedColumnName = "id")
    List<Ronds> ronds = new ArrayList<>();
}
