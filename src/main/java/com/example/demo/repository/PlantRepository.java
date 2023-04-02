package com.example.demo.repository;

import com.example.demo.entity.Plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    //select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id
    @Query("select p from Plant p where p.plantGroupID.plantGrowEnvironmentID.id=:PlantGrowEnvironmentID and p.isDeleted=false ")
    ArrayList<Plant>getAllByPlantGrowEnvironmentID(@Param("PlantGrowEnvironmentID") Long id);

    @Query("select p from Plant p where p.plantGroupID=:groupID and p.isDeleted=false ")
     ArrayList<Plant> getAllByPlantGroupID(@Param("groupID") Long groupid);
    @Override
    @Query("SELECT p FROM Plant p WHERE p.id = :id AND p.isDeleted = false")
    Optional<Plant> findById(@Param("id") Long id);
    @Override
    @Transactional
    default void delete(Plant Plant) {
        Plant.setDeleted(true);
        save(Plant);
    }
}