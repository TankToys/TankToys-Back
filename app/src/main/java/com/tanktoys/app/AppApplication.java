package com.tanktoys.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The above class is a Spring Boot application with a main method to run the
 * application.
 */
@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("${userPath}")
					.allowedOrigins("${CORS_sources}");
				registry.addMapping("${rankingPath}")
					.allowedOrigins("${CORS_sources}");
				registry.addMapping("${tankPath}")
					.allowedOrigins("${CORS_sources}");
				registry.addMapping("${mapPath}")
					.allowedOrigins("${CORS_sources}");
			}
		};
	}
}
