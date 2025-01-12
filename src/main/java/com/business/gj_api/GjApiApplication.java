package com.business.gj_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GjApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GjApiApplication.class, args);
	}

}
