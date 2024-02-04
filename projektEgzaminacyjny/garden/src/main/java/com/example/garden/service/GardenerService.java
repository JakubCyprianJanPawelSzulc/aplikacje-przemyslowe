package com.example.garden.service;

import com.example.garden.model.Gardener;
import com.example.garden.model.Garden;
import com.example.garden.repository.GardenerRepository;
import com.example.garden.repository.GardenRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GardenerService {

    private final GardenerRepository gardenerRepository;
    private final GardenRepository gardenRepository;

    @Autowired
    public GardenerService(GardenerRepository gardenerRepository, GardenRepository gardenRepository) {
        this.gardenerRepository = gardenerRepository;
        this.gardenRepository = gardenRepository;
    }

    public List<Gardener> getAllGardeners() {
        return gardenerRepository.findAll();
    }

    public Optional<Gardener> getGardenerById(Long id) {
        return gardenerRepository.findById(id);
    }

    public Gardener saveGardener(Gardener gardener) {
        return gardenerRepository.save(gardener);
    }

    public void deleteGardener(Long id) {
        gardenerRepository.deleteById(id);
    }

    public List<Garden> getGardensByGardenerName(String gardenerName) {
        return gardenRepository.findByGardenerName(gardenerName);
    }

    public void setGardenerToGarden(Long gardenerId, Long gardenId) {
        Gardener gardener = gardenerRepository.findById(gardenerId).orElseThrow(() -> new RuntimeException("No gardener with id " + gardenerId));
        Garden garden = gardenRepository.findById(gardenId).orElseThrow(() -> new RuntimeException("No garden with id " + gardenId));

        gardener.getGardens().add(garden);
        garden.getGardeners().add(gardener);

        gardenerRepository.save(gardener);
        gardenRepository.save(garden);
    }
}
