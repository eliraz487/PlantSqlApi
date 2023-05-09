/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.sensor.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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
@Table(name = "SensorTypeVSCheckValue")
public class SensorTypeVSCheckValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Value")
    private double value;
    @Basic(optional = false)
    @Column(name = "ValueTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueTime;
    @JoinColumn(name = "SensorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sensor sensorID;
    @JoinColumn(name = "SensorTypeVSCheckID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SensorTypeVSCheck sensorTypeVSCheckID;

}
