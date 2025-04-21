package com.example.jwt.jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
//@ComponentScan("com.example.jwt.jwt.controller")
public class EazyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBackendApplication.class, args);
	}

}
