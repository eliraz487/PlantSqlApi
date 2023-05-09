package com.example.demo.plants.repository;

import com.example.demo.plants.entity.Ages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgesRepository extends JpaRepository<Ages, Long> {

}