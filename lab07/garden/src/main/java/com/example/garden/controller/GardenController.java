package com.example.garden.controller;

import com.example.garden.model.Plant;
import com.example.garden.service.GardenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
public class GardenController {

    private final GardenService gardenService;

    public GardenController(GardenService gardenService) {
        this.gardenService = gardenService;
    }

    @GetMapping("/plants")
    public String plants(Model model) {
        model.addAttribute("list", gardenService.getAllPlants());
        return "list";
    }

    @GetMapping("/plants/{id}")
    public String plantDetails(@PathVariable("id") UUID id, Model model){
        Plant plant = gardenService.getPlant(id);

        if (plant != null) {
            model.addAttribute("plant", plant);
            return "details";
        } else {
            return "redirect:/plants";
        }
    }

    @GetMapping("/plants/form")
    public String plantsForm(Model model) {
        model.addAttribute("plant", new Plant("","",""));
        return "add";
    }

    @PostMapping("/plants/form")
    public String addPlant(@ModelAttribute Plant newPlant, Model model) {
        UUID plantId = gardenService.addPlant(newPlant);

        model.addAttribute("successMessage", "Roślina została dodana pomyślnie");
        model.addAttribute("list", gardenService.getAllPlants());
        model.addAttribute("plantId", plantId);
        return "list";
    }

    @GetMapping("/plants/{id}/edit")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Plant existingPlant = gardenService.getPlant(id);

        if (existingPlant != null) {
            model.addAttribute("plant", existingPlant);
            return "edit";
        } else {
            model.addAttribute("errorMessage", "Nie znaleziono rośliny o podanym identyfikatorze");
            return "error";
        }
    }


    @PostMapping("/plants/{id}/edit")
    public String plantsEdit(@PathVariable("id") UUID id, @ModelAttribute Plant updatedPlant, Model model) {
        Plant existingPlant = gardenService.getPlant(id);

        if (existingPlant != null) {
            existingPlant.setName(updatedPlant.getName());
            existingPlant.setType(updatedPlant.getType());
            existingPlant.setColor(updatedPlant.getColor());


            gardenService.editPlant(id, updatedPlant.getName(), updatedPlant.getType(), updatedPlant.getColor());

            model.addAttribute("successMessage", "Operacja powiodła się");
            model.addAttribute("list", gardenService.getAllPlants());
            return "list";
        } else {
            model.addAttribute("errorMessage", "Nie znaleziono rośliny o podanym identyfikatorze");
            return "error";
        }
    }

    @GetMapping("/plants/{id}/delete")
    public String plantsDelete(@PathVariable("id") String id, Model model) {
        gardenService.deletePlant(id);
        return "redirect:/plants";
    }

}

