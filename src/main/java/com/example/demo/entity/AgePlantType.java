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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class AgePlantType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @JoinColumn(name = "Ages", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Ages ages;
    @JoinColumn(name = "plantTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PlantType plantTypeID;

    public AgePlantType() {
    }

    public AgePlantType(Long id) {
        this.id = id;
    }

    public AgePlantType(Long id, Date fromDate, Date toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Ages getAges() {
        return ages;
    }

    public void setAges(Ages ages) {
        this.ages = ages;
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
        if (!(object instanceof AgePlantType)) {
            return false;
        }
        AgePlantType other = (AgePlantType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication25.AgePlantType[ id=" + id + " ]";
    }
    
}
