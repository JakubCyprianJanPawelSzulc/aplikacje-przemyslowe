package com.example.garden.controller;

import com.example.garden.model.Garden;
import com.example.garden.model.Plant;
import com.example.garden.repository.PlantRepository;
import com.example.garden.service.GardenService;
import com.example.garden.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plants = plantService.getAllPlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id)
                .map(plant -> new ResponseEntity<>(plant, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
        Plant savedPlant = plantService.savePlant(plant);
        return new ResponseEntity<>(savedPlant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plant> savePlant(@RequestBody Plant plant) {
        Plant savedPlant = plantService.savePlant(plant);
        return new ResponseEntity<>(savedPlant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Plant>> searchPlants(@RequestParam(name = "color", required = false) String color,
                                                    @RequestParam(name = "type", required = false) String type,
                                                    @RequestParam(name = "name", required = false) String name) {
        if (color != null && type != null && name != null) {
            List<Plant> plants = plantService.getPlantsByColorAndTypeAndName(color, type, name);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        if (color != null && type != null) {
            List<Plant> plants = plantService.getPlantsByColorAndType(color, type);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        if (color != null && name != null) {
            List<Plant> plants = plantService.getPlantsByColorAndName(color, name);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        if (name != null) {
            List<Plant> plants = plantService.findByName(name);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        if (color != null) {
            List<Plant> plants = (List<Plant>) plantService.getPlantsByColor(color);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        if (type != null) {
            List<Plant> plants = (List<Plant>) plantService.getPlantsByType(type);
            return new ResponseEntity<>(plants, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
