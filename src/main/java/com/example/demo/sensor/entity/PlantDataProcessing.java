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
@Table(name = "PlantDataProcessing")
public class PlantDataProcessing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "RangeOfChange")
    private double rangeOfChange;
    @Basic(optional = false)
    @Column(name = "LossingWater")
    private double lossingWater;
    @Basic(optional = false)
    @Column(name = "WaterConsumption")
    private double waterConsumption;
    @JoinColumn(name = "PlantAgePlantTypeID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AgePlantType plantAgePlantTypeID;
    @JoinColumn(name = "CheckID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SensorTypeVSCheck checkID;

}
