package com.example.garden.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.example.garden.model.Plant;
import com.example.garden.model.Garden;
import com.example.garden.repository.PlantRepository;
import com.example.garden.repository.GardenRepository;
import com.example.garden.repository.GardenerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GardenService {

    final PlantRepository plantRepository;
    final GardenRepository gardenRepository;

    final GardenerRepository gardenerRepository;

    public GardenService(PlantRepository plantRepository, GardenRepository gardenRepository, GardenerRepository gardenerRepository) {
        this.plantRepository = plantRepository;
        this.gardenRepository = gardenRepository;
        this.gardenerRepository = gardenerRepository;
    }

    public List<Garden> getAllGardens() {
        return gardenRepository.getAllGardens();
    }

    public Garden addGarden(Garden garden) {
        return gardenRepository.save(garden);
    }

    public Optional<Garden> findGarden(Long id) {
        return gardenRepository.findById(id);
    }

    public Garden saveGarden(Garden garden) {
        return gardenRepository.save(garden);
    }

    public void deleteGarden(Long id) {
        gardenRepository.deleteById(id);
    }

    public List<Plant> getPlantsByGardenId(Long gardenId) {
        return plantRepository.findByGardenId(gardenId);
    }

    public void setPlantToGarden(Long plantId, Long gardenId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(() -> new RuntimeException("No plant with id " + plantId));
        Garden garden = gardenRepository.findById(gardenId).orElseThrow(() -> new RuntimeException("No garden with id " + gardenId));

        plant.setGarden(garden);
        plantRepository.save(plant);

        garden.getPlants().add(plant);
        gardenRepository.save(garden);
    }

    public void removePlantFromGarden(Long plantId, Long gardenId) {
        Plant plant = plantRepository.findById(plantId).orElseThrow(() -> new RuntimeException("No plant with id " + plantId));
        Garden garden = gardenRepository.findById(gardenId).orElseThrow(() -> new RuntimeException("No garden with id " + gardenId));
        plant.setGarden(null);
        plantRepository.save(plant);
        garden.getPlants().remove(plant);
        gardenRepository.save(garden);
    }

    public List<Garden> findByName(String name) {
        return gardenRepository.findByName(name);
    }

    public List<Garden> findByStreet(String street) {
        return gardenRepository.findByStreet(street);
    }

    public List<Garden> findByStreetAndNumber(String street, Integer number) {
        return gardenRepository.findByStreetAndNumber(street, number);
    }

    public List<Garden> findByNumber(Integer number) {
        return gardenRepository.findByNumber(number);
    }

    public List<Garden> findByGardenerName(String gardenerName) {
        return gardenRepository.findByGardenerName(gardenerName);
    }

    public List<Garden> findByNumberOfPlantsGreaterThan(int number) {
        return gardenRepository.findByNumberOfPlantsGreaterThan(number);
    }

    public List<Garden> findByGardenersIsNotEmpty() {
        return gardenRepository.findByGardenersIsNotEmpty();
    }

    public List<Object[]> findByPlantsColorAndCount(String plantColor) {
        return gardenRepository.findByPlantsColorAndCount(plantColor);
    }
    public void learning() {
//        Plant plant1 = new Plant();
//        plant1.setName("Grass");
//        plant1.setType("Poaceae");
//        plant1.setColor("Green");
//        Plant plant2 = new Plant();
//        plant2.setName("Buxus");
//        plant2.setType("Buxaceae");
//        plant2.setColor("Green");
//        Plant plant3 = new Plant();
//        plant3.setName("Thuja");
//        plant3.setType("Shrub");
//        plant3.setColor("Green");
//
//        List<Plant> plants = new ArrayList<>();
//        plants.add(plant1);
//        plants.add(plant2);
//        plants.add(plant3);
//
//
//        Garden garden1 = new Garden();
//        garden1.setName("Park Oliwski");
//        garden1.setPlants(plants);
//        garden1.setStreet("Opata Jacka Rybińskiego");
//        garden1.setNumber(1);
//
//        saveGarden(garden1);
//
//        Plant plant4 = new Plant();
//        plant4.setName("Rose");
//        plant4.setType("Rosaceae");
//        plant4.setColor("Red");
//        Plant plant5 = new Plant();
//        plant5.setName("Berberis");
//        plant5.setType("Berberidaceae");
//        plant5.setColor("Green");
//
//        List<Plant> plants2 = new ArrayList<>();
//        plants2.add(plant4);
//        plants2.add(plant5);
//
//        Garden garden2 = new Garden();
//        garden2.setName("Mateusz");
//        garden2.setPlants(plants2);
//        garden2.setStreet("Ketlinga");
//        garden2.setNumber(6);
//
//        saveGarden(garden2);


//        gardenRepository.findByStreet("Ketlinga");
//        gardenRepository.findByStreetOrNumber("Ketlinga", 6).forEach(System.out::println);


        // Tx.commit
        // catch
        //  ... Tx.rollback
    }


}
