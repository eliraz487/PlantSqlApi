package com.example.demo.sensor.repository;

import com.example.demo.sensor.entity.CheckTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CheckTableRepository extends JpaRepository<CheckTable, Long>, JpaSpecificationExecutor<CheckTable> {

}