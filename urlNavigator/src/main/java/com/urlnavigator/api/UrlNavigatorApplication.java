package com.urlnavigator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.urlnavigator.api.entity")
public class UrlNavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlNavigatorApplication.class, args);
		// Updated on Feb-21-2025
	}

}
