package com.example.garden.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.garden.model.Plant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
@Repository
public interface PlantRepository extends CrudRepository<Plant, Long> {
    List<Plant> findByColor(String color);
    List<Plant> findByType(String type);
    List<Plant> findByGardenId(long gardenId);
    @Query("SELECT p FROM Plant p WHERE p.color = :color AND p.type = :type")
    List<Plant> findByColorAndType(@Param("color") String color, @Param("type") String type);
    @Query("SELECT p FROM Plant p WHERE p.fertilizer.name = :fertilizerName")
    List<Plant> findByFertilizerName(String fertilizerName);

}
