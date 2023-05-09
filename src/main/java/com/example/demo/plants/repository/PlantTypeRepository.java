package com.example.demo.plants.repository;

import com.example.demo.plants.entity.PlantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantTypeRepository extends JpaRepository<PlantType, Long> {

}