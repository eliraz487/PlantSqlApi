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
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author manra
 */

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(catalog = "Plants", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@Data
public class PlantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String familyID;
    @Column(length = 2147483647)
    private String url;
    @Lob
    @Column(length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantTypeID")
    private List<AgePlantType> agePlantTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantTypeID")
    private List<WateringRequirement> wateringRequirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private List<Plant> plantList;



}
