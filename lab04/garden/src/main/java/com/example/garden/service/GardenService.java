package com.example.garden.service;

import org.springframework.stereotype.Service;
import com.example.garden.model.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GardenService {

    private List<Plant> plants;

    public GardenService() {
        this.plants = new ArrayList<>();
    }

    public List<Plant> getAllPlants() {
        return this.plants;
    }

    public Plant getPlant(UUID id) {
        for (Plant plant : plants) {
            if (plant.getId().equals(id)) {
                return plant;
            }
        }
        return null;
    }

    public void addPlant(String name, String type, String color) {
        plants.add(new Plant(name, type, color));
    }

    public void editPlant(UUID id, String newName, String newType, String newColor) {
        for (Plant plant : plants) {
            if (plant.getId().equals(id)) {
                plant.setName(newName);
                plant.setType(newType);
                plant.setColor(newColor);
                return;
            }
        }
    }

    public void deletePlant(UUID id) {
        plants.removeIf(plant -> plant.getId().equals(id));
    }
}
