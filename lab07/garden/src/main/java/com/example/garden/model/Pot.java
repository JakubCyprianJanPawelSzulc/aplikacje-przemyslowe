package com.example.garden.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pot {
    private UUID id;
    private String material;
    private int size;

    private List<Plant> plants;

    public Pot() {
        this.id = UUID.randomUUID();
        this.plants = new ArrayList<>();
    }

    public Pot(String material, int size) {
        this();
        this.material = material;
        this.size = size;
    }

    public UUID getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public int getSize() {
        return size;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    @Override
    public String toString() {
        return "Pot{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", size=" + size +
                ", plants=" + plants.size() +
                '}';
    }
}
