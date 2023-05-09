package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.SensorVSGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SensorVSGroupRepository extends JpaRepository<SensorVSGroup, Long>, JpaSpecificationExecutor<SensorVSGroup> {

}