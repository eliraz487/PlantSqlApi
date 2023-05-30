package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.CheckRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CheckRequirementRepository extends JpaRepository<CheckRequirement, Long>, JpaSpecificationExecutor<CheckRequirement> {

    @Query(value = "SELECT cr FROM CheckRequirement cr where cr=:plantID")
    ArrayList<CheckRequirement> getCheckRequirementByPlantID(  @Param("plantID") long plantID);
}