package com.accenture.pruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.accenture")
public class PruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

}
