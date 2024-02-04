package com.example.garden.model;
import java.util.UUID;
//import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private String color;

    @OneToOne
    public Fertilizer fertilizer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Pot pot;

    @ManyToOne
    public Garden garden;
}
