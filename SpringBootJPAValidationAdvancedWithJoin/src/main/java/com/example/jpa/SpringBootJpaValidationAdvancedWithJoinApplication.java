package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaValidationAdvancedWithJoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaValidationAdvancedWithJoinApplication.class, args);
		System.out.println("Spring Boot JPA App with server side validations with Advanced Joins started!");
	}

}
