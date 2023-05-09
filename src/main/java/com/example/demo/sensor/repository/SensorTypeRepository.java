package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorTypeRepository extends JpaRepository<SensorType, Long>, JpaSpecificationExecutor<SensorType> {

}