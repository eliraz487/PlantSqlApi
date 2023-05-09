package com.example.demo.repository;

import com.example.demo.entity.PlantGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface PlantGroupRepository extends JpaRepository<PlantGroup, Long> {
    @Query("select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id and e.isDeleted=false ")
    PlantGroup getByNameAndPlantGrowEnvironmentID(@Param("name")String name , @Param("id")Long id);
    //getByNameAndPlantGrowEnvironmentID
    //getAllPlantGroupByPlantGrowEnvironmentID
    @Query("select e from PlantGroup e where e.plantGrowEnvironmentID.id=:id and e.isDeleted=false")
     ArrayList<PlantGroup> getAllPlantGroupByPlantGrowEnvironmentID(@Param("id")Long id);

    @Override
    @Query("SELECT p FROM PlantGroup p WHERE p.id = :id AND p.isDeleted = false")
    Optional<PlantGroup> findById(@Param("id") Long id);

}
