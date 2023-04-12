package com.az.HT.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class HTApiConfiguration {

	@Bean
	public OpenAPI practicalJavaOpenApi() {
		var info = new Info().title("HT API")
				.description("HTApi documentation for Astra Zeneca status services web application").version("1.8");
		return new OpenAPI().info(info);
	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "PUT",
				"DELETE");
	}
}
