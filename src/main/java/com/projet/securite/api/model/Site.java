package com.projet.securite.api.model;

import com.projet.securite.authUser.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Site implements Serializable {
    @Id //specifies to primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_de_site", nullable = false, unique = true)
    private String name;
    @Column(name = "adresse_de_site")
    private String adresse;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="site_id", referencedColumnName = "id")
        List<Ronds> ronds = new ArrayList<>();

    public Site(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }
}
