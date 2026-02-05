package com.wellsfargo.counselor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * This class starts the application and enables JPA/H2 auto-configuration.
 */
@SpringBootApplication
public class Entrypoint {

    public static void main(String[] args) {
        // Starts the Spring Boot application
        SpringApplication.run(Entrypoint.class, args);
    }

}
