package com.example.notesbackend.config;

import com.example.notesbackend.service.NoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Startup configuration to seed demo data.
 */
@Configuration
public class StartupConfig {

    @Bean
    CommandLineRunner seedNotes(NoteService service) {
        return args -> service.seedIfEmpty();
    }
}
