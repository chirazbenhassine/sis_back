package com.projet.securite.service;import com.projet.securite.domain.Role;import com.projet.securite.domain.User;import java.util.List;public interface UserService {    User saveUser(User user);    Role saveRole(Role role);    void addRoleToUser(String username, String roleName);    User getUser(String username);    List<User>getUsers();}