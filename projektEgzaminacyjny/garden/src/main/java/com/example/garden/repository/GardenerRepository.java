package com.example.garden.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.garden.model.Gardener;

@Repository
public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}
