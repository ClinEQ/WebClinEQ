/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Elijah
 */
@Embeddable
public class StudySiteMapPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Basic(optional = false)
    @Column(name = "EQ_SITE_ID")
    private String eqSiteId;

    public StudySiteMapPK() {
    }

    public StudySiteMapPK(String eqStudyId, String eqSiteId) {
        this.eqStudyId = eqStudyId;
        this.eqSiteId = eqSiteId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqSiteId() {
        return eqSiteId;
    }

    public void setEqSiteId(String eqSiteId) {
        this.eqSiteId = eqSiteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqStudyId != null ? eqStudyId.hashCode() : 0);
        hash += (eqSiteId != null ? eqSiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudySiteMapPK)) {
            return false;
        }
        StudySiteMapPK other = (StudySiteMapPK) object;
        if ((this.eqStudyId == null && other.eqStudyId != null) || (this.eqStudyId != null && !this.eqStudyId.equals(other.eqStudyId))) {
            return false;
        }
        if ((this.eqSiteId == null && other.eqSiteId != null) || (this.eqSiteId != null && !this.eqSiteId.equals(other.eqSiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudySiteMapPK[ eqStudyId=" + eqStudyId + ", eqSiteId=" + eqSiteId + " ]";
    }
    
}
