package com.example.demo.plants.repository;

import com.example.demo.plants.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    //select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id
    @Query("select p from Plant p where p.plantGroupID.plantGrowEnvironmentID.id=:PlantGrowEnvironmentID and p.isDeleted=false ")
    ArrayList<Plant>getAllByPlantGrowEnvironmentID(@Param("PlantGrowEnvironmentID") Long id);

    @Query("select p from Plant p where p.plantGroupID=:groupID")
     ArrayList<Plant> getAllByPlantGroupID(@Param("groupID") Long groupid);
    @Override
    @Query("SELECT p FROM Plant p WHERE p.id = :id ")
    Optional<Plant> findById(@Param("id") Long id);

}