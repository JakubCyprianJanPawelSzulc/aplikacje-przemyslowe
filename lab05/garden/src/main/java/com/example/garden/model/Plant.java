package com.example.garden.model;
import java.util.UUID;

public class Plant {
    private UUID id;
    private String name;
    private String type;

    private String color;

    public Plant() {}

    public Plant(String name, String type, String color) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.color = color;
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

    public String getColor(){
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color){
        this.color = color;
    }

}
