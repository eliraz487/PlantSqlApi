/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manra
 */
@MappedSuperclass
@Table(catalog = "Plants", schema = "dbo")
@XmlRootElement
public class WateringRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private double phFrom;
    @Basic(optional = false)
    @Column(nullable = false)
    private double phTo;
    @Basic(optional = false)
    @Column(nullable = false)
    private int soilMoistureFrom;
    @Basic(optional = false)
    @Column(nullable = false)
    private int soilMoistureTo;
    @JoinColumn(name = "AgeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Ages ageID;
    @JoinColumn(name = "PlantTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantType plantTypeID;

    public WateringRequirement() {
    }

    public WateringRequirement(Long id) {
        this.id = id;
    }

    public WateringRequirement(Long id, double phFrom, double phTo, int soilMoistureFrom, int soilMoistureTo) {
        this.id = id;
        this.phFrom = phFrom;
        this.phTo = phTo;
        this.soilMoistureFrom = soilMoistureFrom;
        this.soilMoistureTo = soilMoistureTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPhFrom() {
        return phFrom;
    }

    public void setPhFrom(double phFrom) {
        this.phFrom = phFrom;
    }

    public double getPhTo() {
        return phTo;
    }

    public void setPhTo(double phTo) {
        this.phTo = phTo;
    }

    public int getSoilMoistureFrom() {
        return soilMoistureFrom;
    }

    public void setSoilMoistureFrom(int soilMoistureFrom) {
        this.soilMoistureFrom = soilMoistureFrom;
    }

    public int getSoilMoistureTo() {
        return soilMoistureTo;
    }

    public void setSoilMoistureTo(int soilMoistureTo) {
        this.soilMoistureTo = soilMoistureTo;
    }

    public Ages getAgeID() {
        return ageID;
    }

    public void setAgeID(Ages ageID) {
        this.ageID = ageID;
    }

    public PlantType getPlantTypeID() {
        return plantTypeID;
    }

    public void setPlantTypeID(PlantType plantTypeID) {
        this.plantTypeID = plantTypeID;
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
        if (!(object instanceof WateringRequirement)) {
            return false;
        }
        WateringRequirement other = (WateringRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.WateringRequirement[ id=" + id + " ]";
    }
    
}
