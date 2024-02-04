package com.example.garden.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Gardener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    @ManyToMany(mappedBy = "gardeners", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Garden> gardens;
}