/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.plants.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "PlantType")
@Entity
public class PlantType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "familyID")
    private String familyID;
    @Column(name = "url")
    private String url;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantTypeID")
    private List<AgePlantType> agePlantTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private List<Plant> plantList;

}
