package com.projet.securite.api.model;

import com.projet.securite.authUser.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name="site_fk",referencedColumnName = "id")
   List<User> users = new ArrayList<>();
}
