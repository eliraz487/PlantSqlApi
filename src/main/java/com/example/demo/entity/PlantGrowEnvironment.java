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
public class PlantGrowEnvironment implements Serializable {
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
    @Column(nullable = false)
    private boolean isDeleted;
    @Basic(optional = false)
    @Column(nullable = false)
    private long userOwnerID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plantGrowEnvironmentID")
    private List<PlantGroup> plantGroupList;

    public PlantGrowEnvironment() {
    }

    public PlantGrowEnvironment(Long id) {
        this.id = id;
    }

    public PlantGrowEnvironment(Long id, String name, boolean isDeleted, long userOwnerID) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.userOwnerID = userOwnerID;
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

    public long getUserOwnerID() {
        return userOwnerID;
    }

    public void setUserOwnerID(long userOwnerID) {
        this.userOwnerID = userOwnerID;
    }

    @XmlTransient
    public List<PlantGroup> getPlantGroupList() {
        return plantGroupList;
    }

    public void setPlantGroupList(List<PlantGroup> plantGroupList) {
        this.plantGroupList = plantGroupList;
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
        if (!(object instanceof PlantGrowEnvironment)) {
            return false;
        }
        PlantGrowEnvironment other = (PlantGrowEnvironment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.PlantGrowEnvironment[ id=" + id + " ]";
    }
    
}
