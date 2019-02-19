package com.sjg.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SjgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjgApplication.class, args);
	}

}

