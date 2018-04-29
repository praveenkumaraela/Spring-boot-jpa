package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example","customexceptions"})
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
}
