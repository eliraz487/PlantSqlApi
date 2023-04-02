package com.example.demo.repository;

import com.example.demo.entity.WateringRequirement;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface WateringRequirementRepository extends JpaRepository<WateringRequirement, Long> {

}