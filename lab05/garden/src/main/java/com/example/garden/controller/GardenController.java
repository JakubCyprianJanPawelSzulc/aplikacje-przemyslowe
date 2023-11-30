package com.example.garden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.garden.model.Plant;
import com.example.garden.service.GardenService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/plants")
public class GardenController {

    private final GardenService gardenService;

    @Autowired
    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping
    public ModelAndView getAllPlants() {
        List<Plant> plants = gardenService.getAllPlants();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("plants", plants);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable UUID id) {
        Plant plant = gardenService.getPlant(id);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public String addPlant(@ModelAttribute Plant plant) {
        gardenService.addPlant(plant.getName(), plant.getType(), plant.getColor());
        return "redirect:/plants";
    }
}