package com.example.garden.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Garden {
    private UUID id;
    private String name;

    private List<Plant> plants;

    public Garden() {
        this.id = UUID.randomUUID();
        this.plants = new ArrayList<>();
    }

    public Garden(String name) {
        this();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    @Override
    public String toString() {
        return "Garden{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", plants=" + plants.size() +
                '}';
    }
}
