package com.rusia2018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Rusia2018Application {

	public static void main(String[] args) {
		SpringApplication.run(Rusia2018Application.class, args);
	}
}
