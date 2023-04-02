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
import java.util.Date;
import javax.persistence.*;


/**
 *
 * @author manra
 */

@Table(catalog = "Plants", schema = "dbo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date plantingDate;
    @Lob
    @Column(length = 2147483647)
    private String description;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean isDeleted;
    @JoinColumn(name = "PlantGroupID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantGroup plantGroupID;
    @JoinColumn(name = "TypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantType typeID;



}
