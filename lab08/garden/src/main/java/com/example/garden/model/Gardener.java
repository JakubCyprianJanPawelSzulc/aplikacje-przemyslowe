package com.example.garden.model;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class Gardener {
    private long id;
    private String name;

    private List<Garden> gardens;

    public Gardener() {
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

    @ManyToMany(mappedBy = "gardeners")
    public List<Garden> getGardens() {
        return gardens;
    }

    public void setGardens(List<Garden> gardens) {
        this.gardens = gardens;
    }
}