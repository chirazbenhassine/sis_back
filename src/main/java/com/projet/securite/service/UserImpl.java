package com.projet.securite.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.securite.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class UserImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String nom;

    private String prenom;


    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserImpl(Long id, String username, String nom, String prenom, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserImpl build(User user) {
        //com.projet.securite.domain.User user = .findByUsername(build().getUsername());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new UserImpl(
                user.getId(),
                user.getUsername(),
                user.getNom(),
                user.getPrenom(),
                user.getPassword(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserImpl user = (UserImpl) o;
        return Objects.equals(id, user.id);
    }

    public String getPrenom() {return prenom;
    }
}
