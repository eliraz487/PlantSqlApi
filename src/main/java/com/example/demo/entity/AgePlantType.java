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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(catalog = "Plants", schema = "dbo")
@Data
public class AgePlantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "Ages", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Ages ages;
    @JoinColumn(name = "plantTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantType plantTypeID;



}
