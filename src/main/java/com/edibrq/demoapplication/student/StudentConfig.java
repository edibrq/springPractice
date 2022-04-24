package com.edibrq.demoapplication.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student bob = new Student(
                    "Bob",
                    LocalDate.of(2000, 3, 12),
                    "ekek@kek.com");

            Student eduard = new Student(
                    "Eduard",
                    LocalDate.of(2000, 3, 12),
                    "eduard@kek.com");

            repository.saveAll(
                    List.of(bob, eduard)
            );
        };
    }
}
