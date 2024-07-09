package com.desafioApi.ApiCarros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public OpenAPI CustomOpenApi() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("Swagger")
				.description("Documentação da API de carros!"));
	}
	
}
