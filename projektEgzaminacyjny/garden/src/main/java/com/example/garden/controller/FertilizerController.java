package com.example.garden.controller;

import com.example.garden.model.Fertilizer;
import com.example.garden.repository.FertilizerRepository;
import com.example.garden.service.FertilizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizers")
public class FertilizerController {

    @Autowired
    private FertilizerService fertilizerService;

    @GetMapping
    public ResponseEntity<List<Fertilizer>> getAllFertilizers() {
        List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
        return new ResponseEntity<>(fertilizers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fertilizer> getFertilizerById(@PathVariable Long id) {
        return fertilizerService.getFertilizerById(id)
                .map(fertilizer -> new ResponseEntity<>(fertilizer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Fertilizer> createFertilizer(@RequestBody Fertilizer fertilizer) {
        Fertilizer savedFertilizer = fertilizerService.saveFertilizer(fertilizer);
        return new ResponseEntity<>(savedFertilizer, HttpStatus.CREATED);
    }

    @PutMapping("/{fertilizerId}/plants/{plantId}")
    public ResponseEntity<Void> setFertilizerToPlant(@PathVariable Long fertilizerId, @PathVariable Long plantId) {
        fertilizerService.setFertilizerToPlant(plantId, fertilizerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Fertilizer> updateFertilizer(@PathVariable Long id, @RequestBody Fertilizer updatedFertilizer) {
        return fertilizerService.getFertilizerById(id)
                .map(fertilizer -> {
                    fertilizer.setName(updatedFertilizer.getName());
                    fertilizer.setType(updatedFertilizer.getType());
                    Fertilizer savedFertilizer = fertilizerService.saveFertilizer(fertilizer);
                    return new ResponseEntity<>(savedFertilizer, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFertilizer(@PathVariable Long id) {
        fertilizerService.deleteFertilizer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
