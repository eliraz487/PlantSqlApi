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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manra
 */
@MappedSuperclass
@Table(catalog = "Plants", schema = "dbo")
@XmlRootElement
public class PlantGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean isDeleted;
    @Lob
    @Column(length = 2147483647)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantGroupID")
    private List<Plant> plantList;
    @JoinColumn(name = "PlantGrowEnvironmentID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantGrowEnvironment plantGrowEnvironmentID;

    public PlantGroup() {
    }

    public PlantGroup(Long id) {
        this.id = id;
    }

    public PlantGroup(Long id, String name, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
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

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(List<Plant> plantList) {
        this.plantList = plantList;
    }

    public PlantGrowEnvironment getPlantGrowEnvironmentID() {
        return plantGrowEnvironmentID;
    }

    public void setPlantGrowEnvironmentID(PlantGrowEnvironment plantGrowEnvironmentID) {
        this.plantGrowEnvironmentID = plantGrowEnvironmentID;
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
        if (!(object instanceof PlantGroup)) {
            return false;
        }
        PlantGroup other = (PlantGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.PlantGroup[ id=" + id + " ]";
    }
    
}
