package com.example.jwt.jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan("com.example.jwt.jwt.controller")
//@EnableJpaRepositories("com.example.jwt.jwt.repository")
//@EntityScan("com.example.jwt.jwt.model")
public class EazyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBackendApplication.class, args);
	}

}
