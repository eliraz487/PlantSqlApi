package com.example.demo.repository;

import com.example.demo.entity.PlantGrowEnvironment;
import com.example.demo.vo.PlantGrowEnvironmentVO;
import com.sun.istack.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface PlantGrowEnvironmentRepository extends JpaRepository<PlantGrowEnvironment, Long> {


//findByNameAndUserOwnerID
// getAllUserPlantGrowEnvironment
    //select e from PlantGroup e where e.name=:name and e.plantGrowEnvironmentID.id=:id
    @Query("select e from PlantGrowEnvironment e where e.name=:name and e.userOwnerID=:userID")
    Optional<PlantGrowEnvironmentVO> findByNameAndUserOwnerID(@Param("name") String name,@Param("userID")@NotNull Long userOwnerID);

    @Query("select e from PlantGrowEnvironment e where e.userOwnerID= :userID")
    ArrayList<PlantGrowEnvironment> getAllUserPlantGrowEnvironment(@Param("userID") Long userid);

    @Override
    @Query("SELECT p FROM PlantGrowEnvironment p WHERE p.id = :id")
    Optional<PlantGrowEnvironment> findById(@Param("id") Long id);

}