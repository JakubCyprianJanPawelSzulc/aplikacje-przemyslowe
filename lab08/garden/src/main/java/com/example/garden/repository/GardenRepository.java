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
    @Query("Select m from Manufacture m where m.country=?1 and m.yof=?2")
    List<Garden> getByGardenNameAndColor(String GardenName, String color);
}

