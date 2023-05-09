/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.plants.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "WateringRequirement")
@Entity
public class WateringRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PhFrom")
    private double phFrom;
    @Basic(optional = false)
    @Column(name = "PhTo")
    private double phTo;
    @Basic(optional = false)
    @Column(name = "SoilMoistureFrom")
    private int soilMoistureFrom;
    @Basic(optional = false)
    @Column(name = "SoilMoistureTo")
    private int soilMoistureTo;
    @JoinColumn(name = "AgePlantTypeID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AgePlantType agePlantTypeID;

}
