package com.example.garden.controller;

import com.example.garden.model.Garden;
import com.example.garden.repository.GardenRepository;
import com.example.garden.repository.PlantRepository;
import com.example.garden.service.GardenService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.garden.model.Plant;

@RestController
@RequestMapping("/api/gardens")
public class GardenController {
    @Autowired
    private GardenRepository gardenRepository;
    private final GardenService gardenService;

    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping
    public ResponseEntity<List<Garden>> getAllGardens() {
        List<Garden> gardens = gardenService.getAllGardens();
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Garden> addGarden(@RequestBody Garden garden) {
        Garden savedGarden = gardenService.addGarden(garden);
        return new ResponseEntity<>(savedGarden, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garden> findGarden(@PathVariable Long id) {
        return gardenService.findGarden(id)
                .map(garden -> new ResponseEntity<>(garden, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garden> saveGarden(@RequestBody Garden garden) {
        Garden savedGarden = gardenService.saveGarden(garden);
        return new ResponseEntity<>(savedGarden, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarden(@PathVariable Long id) {
        gardenService.deleteGarden(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{gardenId}/plants")
    public ResponseEntity<List<Plant>> getPlantsByGardenId(@PathVariable Long gardenId) {
        List<Plant> plants = gardenService.getPlantsByGardenId(gardenId);
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @PutMapping("/{gardenId}/plants/{plantId}")
    public ResponseEntity<Void> setPlantToGarden(@PathVariable Long plantId, @PathVariable Long gardenId) {
        gardenService.setPlantToGarden(plantId, gardenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{gardenId}/plants/{plantId}")
    public ResponseEntity<Void> removePlantFromGarden(@PathVariable Long plantId, @PathVariable Long gardenId) {
        gardenService.removePlantFromGarden(plantId, gardenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/plants/count/{number}")
    public ResponseEntity<List<Garden>> getGardensByNumberOfPlantsGreaterThan(@PathVariable int number) {
        List<Garden> gardens = gardenService.findByNumberOfPlantsGreaterThan(number);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }

    @GetMapping("/gardeners/notempty")
    public ResponseEntity<List<Garden>> getGardensByGardenersIsNotEmpty() {
        List<Garden> gardens = gardenService.findByGardenersIsNotEmpty();
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }

    @GetMapping("/plants/color/count/{plantColor}")
    public ResponseEntity<List<Object[]>> getGardensByPlantsColorAndCount(@PathVariable String plantColor) {
        List<Object[]> result = gardenService.findByPlantsColorAndCount(plantColor);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Garden>> searchGardens(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "street", required = false) String street,
                                                        @RequestParam(name = "number", required = false) Integer number,
                                                        @RequestParam(name = "gardenerName", required = false) String gardenerName) {
        if (name != null) {
            List<Garden> gardens = gardenService.findByName(name);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else if (street != null && number != null) {
            List<Garden> gardens = gardenService.findByStreetAndNumber(street, number);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else if (street != null) {
            List<Garden> gardens = gardenService.findByStreet(street);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else if (number != null) {
            List<Garden> gardens = gardenService.findByNumber(number);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else if (gardenerName != null) {
            List<Garden> gardens = gardenService.findByGardenerName(gardenerName);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
