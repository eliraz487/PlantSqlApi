package com.example.demo.plants.repository;

import com.example.demo.plants.entity.AgePlantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgePlantTypeRepository extends JpaRepository<AgePlantType, Long> {

}