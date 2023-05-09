package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.SensorTypeVSCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorTypeVSCheckRepository extends JpaRepository<SensorTypeVSCheck, Long>, JpaSpecificationExecutor<SensorTypeVSCheck> {

}