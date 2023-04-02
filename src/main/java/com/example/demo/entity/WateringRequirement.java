/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author manra
 */

@Entity
@Table(catalog = "Plants", schema = "dbo")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WateringRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private double phFrom;
    @Basic(optional = false)
    @Column(nullable = false)
    private double phTo;
    @Basic(optional = false)
    @Column(nullable = false)
    private int soilMoistureFrom;
    @Basic(optional = false)
    @Column(nullable = false)
    private int soilMoistureTo;
    @JoinColumn(name = "AgeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Ages ageID;
    @JoinColumn(name = "PlantTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantType plantTypeID;


}
