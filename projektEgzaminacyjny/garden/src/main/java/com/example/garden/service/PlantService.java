package com.example.garden.service;

import com.example.garden.model.Plant;
import com.example.garden.repository.PlantRepository;
import com.example.garden.repository.GardenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlantService {

    private final PlantRepository plantRepository;


    @Autowired
    public PlantService(PlantRepository plantRepository, GardenRepository gardenRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }

    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }


    public Iterable<Plant> getPlantsByColor(String color) {
        return plantRepository.findByColor(color);
    }

    public Iterable<Plant> getPlantsByType(String type) {
        return plantRepository.findByType(type);
    }

    public List<Plant> findByName(String name) {
        return plantRepository.findByName(name);
    }

    public List<Plant> getPlantsByColorAndType(String color, String type) {
        return plantRepository.findByColorAndType(color, type);
    }

    public List<Plant> getPlantsByColorAndTypeAndName(String color, String type, String name) {
        return plantRepository.findByColorAndTypeAndName(color, type, name);
    }

    public List<Plant> getPlantsByColorAndName(String color, String name) {
        return plantRepository.findByColorAndName(color, name);
    }

}
