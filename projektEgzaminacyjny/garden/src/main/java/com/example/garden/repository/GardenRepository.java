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


    @Query("Select g from Garden g")
    List<Garden> getAllGardens();

    @Query("Select g from Garden g where g.street=?1 and g.number=?2")
    List<Garden> getByStreetAndNumber(String street, int number);

    @Query("SELECT g FROM Garden g WHERE SIZE(g.plants) > :minNumberOfPlants")
    List<Garden> findByNumberOfPlantsGreaterThan(@Param("minNumberOfPlants") int minNumberOfPlants);

    @Query("SELECT DISTINCT g FROM Garden g JOIN g.gardeners gardener")
    List<Garden> findByGardenersIsNotEmpty();

    @Query("SELECT g, COUNT(p) FROM Garden g JOIN g.plants p WHERE p.color = :plantColor GROUP BY g.id")
    List<Object[]> findByPlantsColorAndCount(@Param("plantColor") String plantColor);

    @Query("SELECT g FROM Garden g WHERE g.number = :number")
    List<Garden> findByNumber(@Param("number") int number);

    @Query("SELECT g FROM Garden g WHERE g.street = :street")
    List<Garden> findByStreet(@Param("street") String street);

    @Query("SELECT g FROM Garden g WHERE g.street = :street AND g.number = :number")
    List<Garden> findByStreetAndNumber(@Param("street") String street, @Param("number") int number);


    @Query("SELECT g FROM Garden g JOIN g.gardeners gardener WHERE gardener.name = :gardenerName")
    List<Garden> findByGardenerName(@Param("gardenerName") String gardenerName);

    List<Garden> findByName(String name);
}

