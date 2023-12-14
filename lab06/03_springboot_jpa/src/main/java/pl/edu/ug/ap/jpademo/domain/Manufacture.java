package pl.edu.ug.ap.jpademo.domain;

import jakarta.persistence.*;

@Entity
public class Manufacture {

    private long id;
    private String name;

    private Car car;

    public Manufacture() {
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

    @OneToOne(mappedBy = "manufacture")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
