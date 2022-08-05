package com.projet.securite.authUser.serviceUser;import com.projet.securite.api.exception.RessourceNotFoundException;import com.projet.securite.api.model.Site;import com.projet.securite.api.repository.SiteRepository;import com.projet.securite.authUser.repository.UserRepository;import com.projet.securite.authUser.model.Role;import com.projet.securite.authUser.model.User;import com.projet.securite.authUser.repository.RoleRepository;import lombok.RequiredArgsConstructor;import lombok.extern.slf4j.Slf4j;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import org.springframework.web.client.ResourceAccessException;import java.util.ArrayList;import java.util.Collection;import java.util.List;@Service@RequiredArgsConstructor@Transactional@Slf4jpublic class UserServiceImpl implements UserService, UserDetailsService  {    private final UserRepository userRepo;    private final RoleRepository roleRepo;    private final SiteRepository siteRepo;    private final PasswordEncoder passwordEncoder;    @Override    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {        User user = userRepo.findByUsername(username);        if(user == null) {            log.error("User not found!");            throw new UsernameNotFoundException("User not found!");        } else {            log.info("User is founded: {}", username);        }        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();        user.getRoles().forEach(role -> {            authorities.add(new SimpleGrantedAuthority(role.getName()));        });        return UserImpl.build(user);    }    @Override    public User saveUser(User user) {        user.setPassword(passwordEncoder.encode(user.getPassword()));        return userRepo.save(user);    }    @Override    public Role saveRole(Role role) {        return roleRepo.save(role);    }    @Override    public void addRoleToUser(String username, String roleName) {    User user = userRepo.findByUsername(username);    Role role = roleRepo.findByName(roleName);    user.getRoles().add(role);    }    @Override    public void addSiteToUser(String username, String SiteName) {        User user = userRepo.findByUsername(username);        Site site= siteRepo.findByName(SiteName);        user.getSites().add(site);    }    @Override    public User getUser(String username) {        return userRepo.findByUsername(username);    }    @Override    public List<User> getUsers() {        return userRepo.findAll();    }    @Override    public User updateUser(User user, Long id) {        //need to check if user  with given id is exist in DB or not        User exidtingUser = userRepo.findById(id).orElseThrow(()-> new RessourceNotFoundException("User","Id",id));        String username = user.getUsername();        String nom = user.getNom();        String prenom = user.getPrenom();        String password = user.getPassword();        if (username != null && username != ""){            exidtingUser.setUsername(user.getUsername());        }        if (nom != null && nom != ""){            exidtingUser.setNom(user.getNom());        }        if (prenom != null && prenom != ""){            exidtingUser.setPrenom(user.getPrenom());        }        if (password != null && password != ""){            exidtingUser.setPassword(passwordEncoder.encode(user.getPassword()));        }        //Save in DB        userRepo.save(exidtingUser);        return exidtingUser;    }    @Override    public void deleteUser(Long id) {        //Check if site exist with given id  is exist in DB        User existingUser = userRepo.findById(id).orElseThrow(()-> new RessourceNotFoundException("User","Id",id));        userRepo.deleteById(id);    }}