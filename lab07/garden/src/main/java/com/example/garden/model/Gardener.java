package com.example.garden.model;
import java.util.UUID;

public class Gardener {
    private UUID id;
    private String name;

    private Plant favoritePlant;

    public Gardener() {
        this.id = UUID.randomUUID();
    }

    public Gardener(String name) {
        this();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Plant getFavoritePlant() {
        return favoritePlant;
    }

    public void setFavoritePlant(Plant favoritePlant) {
        this.favoritePlant = favoritePlant;
    }

    @Override
    public String toString() {
        return "Gardener{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", favoritePlant=" + (favoritePlant != null ? favoritePlant.getName() : "none") +
                '}';
    }
}