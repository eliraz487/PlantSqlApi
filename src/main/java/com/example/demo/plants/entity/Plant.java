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
import java.util.Date;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "Plant")
@Entity
public class Plant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "PlantingDate")
    @Temporal(TemporalType.DATE)
    private Date plantingDate;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "isDeleted")
    private boolean isDeleted;
    @JoinColumn(name = "PlantGroupID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlantGroup plantGroupID;
    @JoinColumn(name = "TypeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlantType typeID;

}
