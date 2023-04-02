/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manra
 */
@MappedSuperclass
@Table(catalog = "Plants", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
public class PlantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String familyID;
    @Column(length = 2147483647)
    private String url;
    @Lob
    @Column(length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantTypeID")
    private List<AgePlantType> agePlantTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantTypeID")
    private List<WateringRequirement> wateringRequirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private List<Plant> plantList;

    public PlantType() {
    }

    public PlantType(Long id) {
        this.id = id;
    }

    public PlantType(Long id, String name, String familyID) {
        this.id = id;
        this.name = name;
        this.familyID = familyID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyID() {
        return familyID;
    }

    public void setFamilyID(String familyID) {
        this.familyID = familyID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<AgePlantType> getAgePlantTypeList() {
        return agePlantTypeList;
    }

    public void setAgePlantTypeList(List<AgePlantType> agePlantTypeList) {
        this.agePlantTypeList = agePlantTypeList;
    }

    @XmlTransient
    public List<WateringRequirement> getWateringRequirementList() {
        return wateringRequirementList;
    }

    public void setWateringRequirementList(List<WateringRequirement> wateringRequirementList) {
        this.wateringRequirementList = wateringRequirementList;
    }

    @XmlTransient
    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
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
        if (!(object instanceof PlantType)) {
            return false;
        }
        PlantType other = (PlantType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.PlantType[ id=" + id + " ]";
    }
    
}
