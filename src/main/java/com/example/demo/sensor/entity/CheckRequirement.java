/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.sensor.entity;

import com.example.demo.plants.entity.AgePlantType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CheckRequirement",schema = "dbo")
public class CheckRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CheckID")
    private Integer checkID;
    @Column(name = "MaxRecommendValue")
    private Integer maxRecommendValue;
    @Column(name = "MinRecommendValue")
    private Integer minRecommendValue;
    @Column(name = "MaxValidValue")
    private Integer maxValidValue;
    @Column(name = "MinValidValue")
    private Integer minValidValue;
    @JoinColumn(name = "AgePlantTypeID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AgePlantType agePlantTypeID;

}
