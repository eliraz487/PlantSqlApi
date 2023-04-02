/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author manra
 */

@AllArgsConstructor
@Builder
@Table(catalog = "Plants", schema = "dbo")
@Data
@Entity
public class PlantGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean isDeleted;
    @Lob
    @Column(length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantGroupID")
    private List<Plant> plantList;
    @JoinColumn(name = "PlantGrowEnvironmentID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantGrowEnvironment plantGrowEnvironmentID;

    public PlantGroup() {
    }

}
