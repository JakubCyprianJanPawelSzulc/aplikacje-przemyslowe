package com.example.garden.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.garden.model.Plant;

@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
}
