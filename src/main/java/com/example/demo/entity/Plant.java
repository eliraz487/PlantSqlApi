/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manra
 */
@MappedSuperclass
@Table(catalog = "Plants", schema = "dbo")
@XmlRootElement
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

    public Plant() {
    }

    public Plant(Long id) {
        this.id = id;
    }

    public Plant(Long id, Date plantingDate, boolean isDeleted) {
        this.id = id;
        this.plantingDate = plantingDate;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public PlantGroup getPlantGroupID() {
        return plantGroupID;
    }

    public void setPlantGroupID(PlantGroup plantGroupID) {
        this.plantGroupID = plantGroupID;
    }

    public PlantType getTypeID() {
        return typeID;
    }

    public void setTypeID(PlantType typeID) {
        this.typeID = typeID;
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
        if (!(object instanceof Plant)) {
            return false;
        }
        Plant other = (Plant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.Plant[ id=" + id + " ]";
    }
    
}
