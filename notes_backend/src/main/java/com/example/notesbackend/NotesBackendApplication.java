package com.example.notesbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PUBLIC_INTERFACE
 * NotesBackendApplication is the Spring Boot entry point for the Notes service.
 * It configures the application context and hosts the REST API with OpenAPI docs.
 */
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Notes Backend API",
                version = "0.1.0",
                description = "Simple CRUD API for managing notes",
                contact = @Contact(name = "Notes API", url = "https://example.com")
        )
)
public class NotesBackendApplication {

    /**
     * PUBLIC_INTERFACE
     * Application entrypoint.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NotesBackendApplication.class, args);
    }
}
