package com.example.jwt.jwt;

import com.example.jwt.jwt.domain.Role;
import com.example.jwt.jwt.domain.User;
import com.example.jwt.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null,"John Travolta","john","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Will Smith","will","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Jim Carry","jim","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Arnold x","arnold","123",new ArrayList<>()));

//			userService.addRoleToUser("john", "ROLE_USER");
//			userService.addRoleToUser("will", "ROLE_MANAGER");
//			userService.addRoleToUser("jim", "ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("arnold", "ROLE_ADMIN");
		};
	}
}
