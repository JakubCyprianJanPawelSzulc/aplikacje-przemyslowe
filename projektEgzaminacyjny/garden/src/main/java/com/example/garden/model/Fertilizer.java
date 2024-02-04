package com.example.garden.model;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Plant plant;

}
