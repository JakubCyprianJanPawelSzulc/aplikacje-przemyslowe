package com.example.garden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.garden.model.Plant;
import com.example.garden.service.GardenService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/plants")
public class GardenController {

    private final GardenService gardenService;

    @Autowired
    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = gardenService.getAllPlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable UUID id) {
        Plant plant = gardenService.getPlant(id);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> addPlant(@RequestBody Plant plant) {
        gardenService.addPlant(plant.getName(), plant.getType(), plant.getColor());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editPlant(@PathVariable UUID id, @RequestBody Plant updatedPlant) {
        if (gardenService.getPlant(id) != null) {
            gardenService.editPlant(id, updatedPlant.getName(), updatedPlant.getType(), updatedPlant.getColor());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable UUID id) {
        if (gardenService.getPlant(id) != null) {
            gardenService.deletePlant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
