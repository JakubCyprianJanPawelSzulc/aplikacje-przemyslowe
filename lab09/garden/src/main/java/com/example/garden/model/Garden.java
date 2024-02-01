package com.example.garden.model;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Garden {
    private Long id;
    private String name;
    private String street;
    private int number;
//    private List<Plant> plants;
//
//    private List<Gardener> gardeners;

    public Garden() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "garden")
//    @JoinColumn(name = "garden_id")
//    public List<Plant> getPlants() {
//        return plants;
//    }
//
//    public void setPlants(List<Plant> plants) {
//        this.plants = plants;
//    }

//    @ManyToMany
//    public List<Gardener> getGardeners() {
//        return gardeners;
//    }
//
//    public void setGardeners(List<Gardener> gardeners) {
//        this.gardeners = gardeners;
//    }

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Garden{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number
                '}';
    }
}
