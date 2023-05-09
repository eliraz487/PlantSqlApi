/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "AgePlantType")
@Entity
public class AgePlantType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    private List<WateringRequirement> wateringRequirementList;
    
}
