package com.example.garden.repository;

import org.springframework.stereotype.Repository;
import com.example.garden.model.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByColor(String color);
    List<Plant> findByType(String type);
    List<Plant> findByGardenId(long gardenId);
    @Query("SELECT p FROM Plant p WHERE p.color = :color AND p.type = :type")
    List<Plant> findByColorAndType(@Param("color") String color, @Param("type") String type);

    List<Plant> findByName(String name);

    List<Plant> findByColorAndTypeAndName(String color, String type, String name);

    List<Plant> findByColorAndName(String color, String name);

}
