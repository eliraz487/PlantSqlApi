/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.sensor.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "SensorTypeVSCheck")
public class SensorTypeVSCheck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @JoinColumn(name = "CheckID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CheckTable checkID;
    @JoinColumn(name = "SensorTypeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SensorType sensorTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensorTypeVSCheckID")
    private List<SensorTypeVSCheckValue> sensorTypeVSCheckValueList;

}
