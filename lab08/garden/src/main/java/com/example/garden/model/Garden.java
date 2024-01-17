package com.example.garden.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Garden {
    private long id;
    private String name;

    private List<Plant> plants;

    private List<Gardener> gardeners;

    public Garden() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "garden")
    @JoinColumn(name = "garden_id")
    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @ManyToMany
    public List<Gardener> getGardeners() {
        return gardeners;
    }

    public void setGardeners(List<Gardener> gardeners) {
        this.gardeners = gardeners;
    }
}
