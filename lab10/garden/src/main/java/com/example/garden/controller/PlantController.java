package com.example.garden.controller;

import com.example.garden.model.Plant;
import com.example.garden.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = (List<Plant>) plantRepository.findAll();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Plant> createPlant(@RequestBody Plant plant) {
        Plant savedPlant = plantRepository.save(plant);
        return new ResponseEntity<>(savedPlant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody Plant updatedPlant) {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant != null) {
            plant.setName(updatedPlant.getName());
            plant.setType(updatedPlant.getType());
            plant.setColor(updatedPlant.getColor());
            // Update other properties as needed

            Plant savedPlant = plantRepository.save(plant);
            return new ResponseEntity<>(savedPlant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        if (plantRepository.existsById(id)) {
            plantRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Plant>> searchPlants(@RequestParam(name = "color", required = false) String color,
                                                    @RequestParam(name = "type", required = false) String type) {
        if (color != null && type != null) {
            List<Plant> plants = plantRepository.findByColorAndType(color, type);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        } else if (color != null) {
            List<Plant> plants = plantRepository.findByColor(color);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        } else if (type != null) {
            List<Plant> plants = plantRepository.findByType(type);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
