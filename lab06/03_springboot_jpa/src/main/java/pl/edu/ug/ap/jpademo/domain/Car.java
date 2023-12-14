package pl.edu.ug.ap.jpademo.domain;

import jakarta.persistence.*;
import org.hibernate.id.factory.internal.IdentityGenerationTypeStrategy;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Car {

    private long id;
    private String name;
    private String make;
    private String yop;

    private Manufacture manufacture;

    public Car() {
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    @OneToOne
    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }
}
