package com.example.garden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
