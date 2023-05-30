package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.CheckTable;
import com.example.demo.sensor.entity.PlantDataProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlantDataProcessingRepository extends JpaRepository<PlantDataProcessing, Long>, JpaSpecificationExecutor<PlantDataProcessing> {

}