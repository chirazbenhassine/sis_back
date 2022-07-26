package com.projet.securite;

import com.projet.securite.domain.Role;
import com.projet.securite.domain.User;
import com.projet.securite.service.UserService;
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

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));


			userService.saveUser(new User(null, "Isaac abdelli", "Isaac", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Bilel Tijaou", "Bilel", "1234", new ArrayList<>()));

			userService.addRoleToUser("Isaac", "ROLE_USER");
			userService.addRoleToUser("Bilel", "ROLE_ADMIN");

		};
	}

}
