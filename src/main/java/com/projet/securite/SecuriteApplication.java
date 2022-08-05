package com.projet.securite;

import com.projet.securite.api.model.Pointeau;
import com.projet.securite.api.model.Ronds;
import com.projet.securite.api.model.Site;
import com.projet.securite.api.repository.PointeauRepository;
import com.projet.securite.api.repository.RondRepository;
import com.projet.securite.api.service.PointeauService;
import com.projet.securite.api.service.RondService;
import com.projet.securite.api.service.SiteService;
import com.projet.securite.authUser.model.Role;
import com.projet.securite.authUser.model.User;
import com.projet.securite.authUser.serviceUser.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecuriteApplication {



	public static void main(String[] args) {
		SpringApplication.run(SecuriteApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*@Override
	public void run(String... args) throws Exception {

		Ronds rond=new Ronds(null,"rond1",new ArrayList<>());
		Pointeau pointeau= new Pointeau(null,"pointeau1");
		rondService.saveRond(rond);
		pointeauService.savePointeau(pointeau);
		//rondService.addPointeauToRond(rond.getName(),pointeau.getName());
		//rond.getPointeaux().add(pointeau);*/
	@Bean
	CommandLineRunner run(UserService userService,SiteService siteService, RondService rondService, PointeauService pointeauService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_CLIENT"));

			userService.saveUser(new User(null, "Abdelli", "Isaac", "Isaacabd","1234", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Tijaou", "Bilel","Bileltj", "1234", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Ben Hassine", "Ali","Alibh", "1234", new ArrayList<>(), new ArrayList<>()));
			userService.saveUser(new User(null, "Ben e", "Ali","Alibha", "1234", new ArrayList<>(), new ArrayList<>()));

			userService.addRoleToUser("Isaacabd", "ROLE_USER");
			userService.addRoleToUser("Bileltj", "ROLE_ADMIN");
			userService.addRoleToUser("Alibh", "ROLE_CLIENT");
            Site site1 = new Site("Auchan","Sartrouville");
            Site site2 = new Site("Carrefour","Paris");
			siteService.saveSite(site1);
			siteService.saveSite(site2);

			userService.addSiteToUser("Alibh", "Auchan");
			userService.addSiteToUser("Bileltj", "Carrefour");


			pointeauService.savePointeau(new Pointeau(null,"pointeau1"));
			pointeauService.savePointeau(new Pointeau(null,"pointeau2"));

			rondService.saveRond(new Ronds(null,"rond1",new ArrayList<>()));
			rondService.saveRond(new Ronds(null,"rond2",new ArrayList<>()));

			rondService.addPointeauToRond(Long.valueOf(1), Long.valueOf(2));
			rondService.addPointeauToRond(1L, 2L);

			siteService.addRondToSite(1L, 1L);
			siteService.addRondToSite(1L, 2L);




		};
	}

	}

	/*@Bean
	CommandLineRunner run(RondService rondService, PointeauService pointeauService) {
		return args -> {

			rondService.saveRond(new Ronds(null,"rond1",new ArrayList<>()));
			rondService.saveRond(new Ronds(null,"rond2",new ArrayList<>()));

			pointeauService.savePointeau(new Pointeau(null,"pointeau1"));
			pointeauService.savePointeau(new Pointeau(null,"pointeau2"));

			rondService.addPointeauToRond("rond1","pointeau2");

		};
	}*/

	

