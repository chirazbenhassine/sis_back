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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Rond")
public class Ronds implements Serializable {
        @Id //specifies to primary key of the entity
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(unique=true)
        private String name;
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Collection<Pointeau> pointeaux = new ArrayList<>();


    }

