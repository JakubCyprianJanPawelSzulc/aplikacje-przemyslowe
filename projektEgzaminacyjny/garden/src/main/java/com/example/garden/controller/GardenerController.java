package com.example.garden.controller;

import com.example.garden.model.Garden;
import com.example.garden.model.Gardener;
import com.example.garden.repository.GardenerRepository;
import com.example.garden.service.GardenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gardeners")
public class GardenerController {

    @Autowired
    private GardenerService gardenerService;

    @GetMapping
    public ResponseEntity<List<Gardener>> getAllGardeners() {
        List<Gardener> gardeners = gardenerService.getAllGardeners();
        return new ResponseEntity<>(gardeners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gardener> getGardenerById(@PathVariable Long id) {
        return gardenerService.getGardenerById(id)
                .map(gardener -> new ResponseEntity<>(gardener, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Gardener> createGardener(@RequestBody Gardener gardener) {
        Gardener savedGardener = gardenerService.saveGardener(gardener);
        return new ResponseEntity<>(savedGardener, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gardener> updateGardener(@PathVariable Long id, @RequestBody Gardener updatedGardener) {
        return gardenerService.getGardenerById(id)
                .map(gardener -> {
                    gardener.setName(updatedGardener.getName());
                    Gardener savedGardener = gardenerService.saveGardener(gardener);
                    return new ResponseEntity<>(savedGardener, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{gardenerId}/gardens/{gardenId}")
    public ResponseEntity<Void> setGardenerToGarden(@PathVariable Long gardenerId, @PathVariable Long gardenId) {
        gardenerService.setGardenerToGarden(gardenerId, gardenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{gardenerId}/gardens/{gardenId}")
    public ResponseEntity<Void> removeGardenerFromGarden(@PathVariable Long gardenerId, @PathVariable Long gardenId) {
        gardenerService.removeGardenerFromGarden(gardenerId, gardenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGardener(@PathVariable Long id) {
        gardenerService.deleteGardener(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{gardenerName}/gardens")
    public ResponseEntity<List<Garden>> getGardensByGardenerName(@PathVariable String gardenerName) {
        List<Garden> gardens = gardenerService.getGardensByGardenerName(gardenerName);
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }


}
