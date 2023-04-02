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
import javax.persistence.Lob;
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
public class Ages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ages")
    private List<AgePlantType> agePlantTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageID")
    private List<WateringRequirement> wateringRequirementList;

    public Ages() {
    }

    public Ages(Long id) {
        this.id = id;
    }

    public Ages(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ages)) {
            return false;
        }
        Ages other = (Ages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.Ages[ id=" + id + " ]";
    }
    
}
