package com.example.garden.controller;

import com.example.garden.model.Garden;
import com.example.garden.repository.GardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gardens")
public class GardenController {

    @Autowired
    private GardenRepository gardenRepository;

    @GetMapping
    public ResponseEntity<List<Garden>> getAllGardens() {
        List<Garden> gardens = (List<Garden>) gardenRepository.findAll();
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garden> getGardenById(@PathVariable Long id) {
        Garden garden = gardenRepository.findById(id).orElse(null);
        if (garden != null) {
            return new ResponseEntity<>(garden, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Garden> createGarden(@RequestBody Garden garden) {
        Garden savedGarden = gardenRepository.save(garden);
        return new ResponseEntity<>(savedGarden, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garden> updateGarden(@PathVariable Long id, @RequestBody Garden updatedGarden) {
        Garden garden = gardenRepository.findById(id).orElse(null);
        if (garden != null) {
            garden.setName(updatedGarden.getName());
            garden.setStreet(updatedGarden.getStreet());
            garden.setNumber(updatedGarden.getNumber());
            // Update other properties as needed

            Garden savedGarden = gardenRepository.save(garden);
            return new ResponseEntity<>(savedGarden, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarden(@PathVariable Long id) {
        if (gardenRepository.existsById(id)) {
            gardenRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Garden>> searchGardens(@RequestParam(name = "street", required = false) String street,
                                                      @RequestParam(name = "number", required = false) Integer number) {
        if (street != null && number != null) {
            List<Garden> gardens = gardenRepository.findByStreetAndNumber(street, number);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else if (street != null) {
            List<Garden> gardens = gardenRepository.findByStreet(street);
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
