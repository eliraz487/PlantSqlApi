/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.plants.entity;

import com.example.demo.sensor.entity.CheckRequirement;
import com.example.demo.sensor.entity.PlantDataProcessing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "AgePlantType", schema = "dbo", catalog = "Plants")
public class AgePlantType  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "FromDate")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(name = "ToDate")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "Ages", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ages ages;
    @JoinColumn(name = "plantTypeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlantType plantTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agePlantTypeID")
    private List<CheckRequirement> checkRequirementList;
    @OneToMany(mappedBy = "agePlantType")
    private List<WateringRequirement> wateringRequirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantAgePlantTypeID")
    private List<PlantDataProcessing> plantDataProcessingList;

}
