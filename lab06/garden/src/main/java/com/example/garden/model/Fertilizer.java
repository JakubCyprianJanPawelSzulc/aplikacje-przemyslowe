package com.example.garden.model;
import java.util.UUID;

public class Fertilizer {
    private UUID id;
    private String name;
    private String type;

    private Plant plant;

    public Fertilizer() {
        this.id = UUID.randomUUID();
    }

    public Fertilizer(String name, String type) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToOne
    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Override
    public String toString() {
        return "Fertilizer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
