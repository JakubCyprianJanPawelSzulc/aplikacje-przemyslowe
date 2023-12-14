package com.example.garden;

import com.example.garden.model.Plant;
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
            gardenService.addPlant(new Plant("Rose", "Flower", "Red"));
            gardenService.addPlant(new Plant("Tulip", "Flower", "Yellow"));
            gardenService.addPlant(new Plant("Thuja", "Tree", "Green"));
        };
    }
}
