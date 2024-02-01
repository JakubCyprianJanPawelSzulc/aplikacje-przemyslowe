package com.example.garden.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.garden.model.Plant;
import com.example.garden.model.Garden;
import com.example.garden.repository.PlantRepository;
import com.example.garden.repository.GardenRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GardenService {

    final PlantRepository plantRepository;
    final GardenRepository gardenRepository;

    public GardenService(PlantRepository plantRepository, GardenRepository gardenRepository) {
        this.plantRepository = plantRepository;
        this.gardenRepository = gardenRepository;
    }

    public Car addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Optional<Plant> findPlant(Long id) {
        return plantRepository.findById(id);
    }

    public void deletePlant(Long id){
        plantRepository.deleteById(id);
    }

    public void learning() {
        // Tx.begin
        Plant plant1 = new Plant("Grass", "Poaceae", "Green");
        Plant plant2 = new Plant("Buxus", "Buxaceae", "Green");
        Plant plant3 = new Plant("Thuja", "Shrub", "Green");

        List<Plant> plants = new ArrayList<>();
        plants.add(plant1);
        plants.add(plant2);
        plants.add(plant3)
        //gardenRepository.saveAll(plants);

        Graden garden1 = new Garden ("Park Oliwski");
        garden1.setPlants(plants);
        garden1.setStreet("Opata Jacka Rybińskiego");
        garden1.setNumber(1)
        Garden gardenRetrieved = gardenRepository.save(garden1);

        Optional<Garden> optGarden = gardenRepository.findById(gardenRetrieved.getId());

        optGarden.ifPresent(garden -> {
            System.out.println(garden.getPlants().size());
        });

        Garden garden2 = new Garden("Mamczyn")
        garden1.setStreet("Ketlinga");
        garden1.setNumber(6)
        gardenRepository.save(garden2);

        gardenRepository.findByStreet("Ketlinga")
        gardenRepository.findByStreetOrNumber("Ketlinga", "6").forEach(System.out::println);


        // Tx.commit
        // catch
        //  ... Tx.rollback
    }

}
