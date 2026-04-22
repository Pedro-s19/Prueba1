package com.example.Futbol.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API GESTIÓN EQUIPO DE FÚTBOL")        // título en Swagger UI
                        .version("1.0")
                        .description("API REST para gestionar jugadores, entrenadores, partidos y estadísticas. " +
                                "Desarrollada con Spring Boot + PostgreSQL (Docker).")
                        .contact(new Contact()
                                .name("Ingeniería de Software - UDEC")
                                .email("ing.software@udec.edu.co")));
    }
}
