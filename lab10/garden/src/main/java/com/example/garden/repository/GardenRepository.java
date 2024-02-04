package com.example.garden.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.garden.model.Garden;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {

    List<Garden> findByStreet(String street);
    List<Garden> findByStreetOrNumber(String street, int number);

    List<Garden> findByStreetAndNumber(String street, Integer number);

    // Query: Świat obiektów JPQL
    @Query("Select g from Garden g")
    List<Garden> getAllGardens();

    // Query: Świat obiektów JPQL
    @Query("Select g from Garden g where g.street=?1 and g.number=?2")
    List<Garden> getByStreetAndNumber(String street, int number);

    @Query("SELECT g FROM Garden g WHERE SIZE(g.plants) > :minNumberOfPlants")
    List<Garden> findByNumberOfPlantsGreaterThan(@Param("minNumberOfPlants") int minNumberOfPlants);

    @Query("SELECT DISTINCT g FROM Garden g JOIN g.gardeners gardener")
    List<Garden> findByGardenersIsNotEmpty();

    @Query("SELECT g, COUNT(p) FROM Garden g JOIN g.plants p WHERE p.color = :plantColor GROUP BY g.id")
    List<Object[]> findByPlantsColorAndCount(@Param("plantColor") String plantColor);
}

