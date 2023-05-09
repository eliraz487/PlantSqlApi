package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.SensorTypeVSCheckValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorTypeVSCheckValueRepository extends JpaRepository<SensorTypeVSCheckValue, Long>, JpaSpecificationExecutor<SensorTypeVSCheckValue> {

}