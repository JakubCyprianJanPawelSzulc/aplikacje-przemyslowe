package com.example.garden;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.garden.service.GardenService;

@SpringBootApplication
public class GardenApplication {

    public static void main(String[] args) {
        SpringApplication.run(GardenApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(GardenService gardenService) {
        return args -> {
            gardenService.addPlant("Rose", "Flower", "Red");
            gardenService.addPlant("Tulip", "Flower", "Yellow");
            gardenService.addPlant("Thuja", "Tree", "Green");
        };
    }
}
