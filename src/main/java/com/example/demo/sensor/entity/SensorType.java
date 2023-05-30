/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.sensor.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author manra
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "SensorType")
public class SensorType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorTypeID")
    private List<SensorTypeVSCheck> sensorTypeVSCheckList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private List<Sensor> sensorList;

}
