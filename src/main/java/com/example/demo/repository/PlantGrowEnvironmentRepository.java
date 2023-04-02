package com.example.demo.repository;

import com.example.demo.entity.PlantGrowEnvironment;
import com.sun.istack.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface PlantGrowEnvironmentRepository extends JpaRepository<PlantGrowEnvironment, Long> {


//findByNameAndUserOwnerID
// getAllUserPlantGrowEnvironment
    //select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id
    @Query("select e from PlantGrowEnvironment e where e.name=:name and e.userOwnerID=:userID and e.isDeleted= false")
    PlantGrowEnvironment findByNameAndUserOwnerID(@Param("name") String name,@Param("userID")@NotNull Long userOwnerID);

    @Query("select e from PlantGrowEnvironment e where e.userOwnerID= :userID and e.isDeleted= false ")
    ArrayList<PlantGrowEnvironment> getAllUserPlantGrowEnvironment(@Param("userID") Long userid);

    @Override
    @Query("SELECT p FROM PlantGrowEnvironment p WHERE p.id = :id AND p.isDeleted = false")
    Optional<PlantGrowEnvironment> findById(@Param("id") Long id);
    @Override
    @Transactional
    default void delete(PlantGrowEnvironment plantGrowEnvironment) {
        plantGrowEnvironment.setDeleted(true);
        save(plantGrowEnvironment);
    }
}