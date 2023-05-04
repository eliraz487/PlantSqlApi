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

@Table(catalog = "Plants", schema = "dbo")
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class PlantGrowEnvironment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;
    @Basic(optional = true)
    @Column(nullable = false)
    private long userOwnerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantGrowEnvironmentID")
    private List<PlantGroup> plantGroupList;



}
