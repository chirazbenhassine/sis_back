package com.projet.securite.api.model;

import com.projet.securite.authUser.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Pointeau")
public class Pointeau {
    @Id //specifies to primary key of the entity
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom_de_pointeaux", nullable = false)
    private String name;


}
