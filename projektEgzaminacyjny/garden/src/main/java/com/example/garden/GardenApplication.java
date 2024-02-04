package com.example.garden;

import com.example.garden.service.GardenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GardenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpApp(GardenService gardenService) {
        return (args) -> {
            gardenService.learning();
        };
    }

}
