package com.example.garden.model;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private String color;

    @OneToOne(mappedBy = "plant", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Fertilizer fertilizer;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Garden garden;

}
