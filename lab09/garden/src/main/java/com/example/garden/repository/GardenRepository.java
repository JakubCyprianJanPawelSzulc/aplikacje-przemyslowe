package com.example.garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.garden.model.Garden;

import java.util.List;

@Repository
public interface GardenRepository extends JpaRepository<GardenName, Long> {

    List<Garden> findByName(String GardenName);
    List<Garden> findByNameAndColor(String GardenName, int color);

    // Query: Świat obiektów JPQL
    @Query("Select m from Garden m")
    List<Garden> getAllGardens();

    // Query: Świat obiektów JPQL
    @Query("Select g from Garden g where g.street=?1 and g.number=?2")
    List<Garden> getByStreetAndNumber(String street, int number);
}

