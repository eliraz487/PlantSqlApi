/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.sensor.entity;

import com.example.demo.plants.entity.Plant;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author manra
 */
@Entity
@Table(name = "SensorVSPlants")
public class SensorVSPlants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @JoinColumn(name = "PlantID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Plant plantID;
    @JoinColumn(name = "SensorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sensor sensorID;

    public SensorVSPlants() {
    }

    public SensorVSPlants(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plant getPlantID() {
        return plantID;
    }

    public void setPlantID(Plant plantID) {
        this.plantID = plantID;
    }

    public Sensor getSensorID() {
        return sensorID;
    }

    public void setSensorID(Sensor sensorID) {
        this.sensorID = sensorID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SensorVSPlants)) {
            return false;
        }
        SensorVSPlants other = (SensorVSPlants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication16.SensorVSPlants[ id=" + id + " ]";
    }
    
}
