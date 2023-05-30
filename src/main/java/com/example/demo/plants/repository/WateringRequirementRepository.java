package com.example.demo.plants.repository;


import com.example.demo.plants.entity.WateringRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WateringRequirementRepository extends JpaRepository<WateringRequirement, Long> {

}