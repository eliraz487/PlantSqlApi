package com.example.demo.plants.repository;

import com.example.demo.plants.entity.PlantGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface
PlantGroupRepository extends JpaRepository<PlantGroup, Long> {
    @Query("select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id ")
    PlantGroup getByNameAndPlantGrowEnvironmentID(@Param("name")String name , @Param("id")Long id);
    //getByNameAndPlantGrowEnvironmentID
    //getAllPlantGroupByPlantGrowEnvironmentID
    @Query("select e from PlantGroup e where e.plantGrowEnvironmentID.id=:id")
     ArrayList<PlantGroup> getAllPlantGroupByPlantGrowEnvironmentID(@Param("id")Long id);

    @Override
    @Query("SELECT p FROM PlantGroup p WHERE p.id = :id ")
    Optional<PlantGroup> findById(@Param("id") Long id);

}
