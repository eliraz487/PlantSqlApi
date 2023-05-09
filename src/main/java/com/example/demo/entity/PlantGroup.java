/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "PlantGroup")
@Entity
public class PlantGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "isDeleted")
    private boolean isDeleted;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantGroupID")
    private List<Plant> plantList;
    @JoinColumn(name = "PlantGrowEnvironmentID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlantGrowEnvironment plantGrowEnvironmentID;

}
