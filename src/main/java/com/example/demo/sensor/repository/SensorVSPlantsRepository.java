package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.SensorVSPlants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorVSPlantsRepository extends JpaRepository<SensorVSPlants, Long>, JpaSpecificationExecutor<SensorVSPlants> {

}