/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "STUDY_SITE_MAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudySiteMap.findAll", query = "SELECT s FROM StudySiteMap s"),
    @NamedQuery(name = "StudySiteMap.findByEqStudyId", query = "SELECT s FROM StudySiteMap s WHERE s.studySiteMapPK.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "StudySiteMap.findByEqSiteId", query = "SELECT s FROM StudySiteMap s WHERE s.studySiteMapPK.eqSiteId = :eqSiteId"),
    @NamedQuery(name = "StudySiteMap.findByLastUpdateDate", query = "SELECT s FROM StudySiteMap s WHERE s.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "StudySiteMap.findByStatus", query = "SELECT s FROM StudySiteMap s WHERE s.status = :status")})
public class StudySiteMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudySiteMapPK studySiteMapPK;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "EQ_SITE_ID", referencedColumnName = "EQ_ORG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizations organizations;

    public StudySiteMap() {
    }

    public StudySiteMap(StudySiteMapPK studySiteMapPK) {
        this.studySiteMapPK = studySiteMapPK;
    }

    public StudySiteMap(String eqStudyId, String eqSiteId) {
        this.studySiteMapPK = new StudySiteMapPK(eqStudyId, eqSiteId);
    }

    public StudySiteMapPK getStudySiteMapPK() {
        return studySiteMapPK;
    }

    public void setStudySiteMapPK(StudySiteMapPK studySiteMapPK) {
        this.studySiteMapPK = studySiteMapPK;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studySiteMapPK != null ? studySiteMapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudySiteMap)) {
            return false;
        }
        StudySiteMap other = (StudySiteMap) object;
        if ((this.studySiteMapPK == null && other.studySiteMapPK != null) || (this.studySiteMapPK != null && !this.studySiteMapPK.equals(other.studySiteMapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudySiteMap[ studySiteMapPK=" + studySiteMapPK + " ]";
    }
    
}
