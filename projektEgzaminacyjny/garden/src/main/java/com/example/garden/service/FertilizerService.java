package com.example.garden.service;

import com.example.garden.model.Fertilizer;
import com.example.garden.model.Plant;
import com.example.garden.repository.PlantRepository;
import com.example.garden.repository.FertilizerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FertilizerService {

    private final PlantRepository plantRepository;
    private final FertilizerRepository fertilizerRepository;

    @Autowired
    public FertilizerService(PlantRepository plantRepository, FertilizerRepository fertilizerRepository) {
        this.plantRepository = plantRepository;
        this.fertilizerRepository = fertilizerRepository;
    }

    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    public Optional<Fertilizer> getFertilizerById(Long id) {
        return fertilizerRepository.findById(id);
    }

    public Fertilizer saveFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    public void deleteFertilizer(Long id) {
        fertilizerRepository.deleteById(id);
    }

    public Iterable<Plant> getPlantsByFertilizerName(String fertilizerName) {
        return plantRepository.findByFertilizerName(fertilizerName);
    }

    public void setFertilizerToPlant(Long plantId, Long fertilizerId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(() -> new RuntimeException("No plant with id " + plantId));
        Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId).orElseThrow(() -> new RuntimeException("No fertilizer with id " + fertilizerId));
        plant.setFertilizer(fertilizer);
        plantRepository.save(plant);
        fertilizer.setPlant(plant);
        fertilizerRepository.save(fertilizer);
    }
}
