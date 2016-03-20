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
public class StudyLocationMapPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Basic(optional = false)
    @Column(name = "EQ_LOCATION_ID")
    private String eqLocationId;

    public StudyLocationMapPK() {
    }

    public StudyLocationMapPK(String eqStudyId, String eqLocationId) {
        this.eqStudyId = eqStudyId;
        this.eqLocationId = eqLocationId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqLocationId() {
        return eqLocationId;
    }

    public void setEqLocationId(String eqLocationId) {
        this.eqLocationId = eqLocationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqStudyId != null ? eqStudyId.hashCode() : 0);
        hash += (eqLocationId != null ? eqLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyLocationMapPK)) {
            return false;
        }
        StudyLocationMapPK other = (StudyLocationMapPK) object;
        if ((this.eqStudyId == null && other.eqStudyId != null) || (this.eqStudyId != null && !this.eqStudyId.equals(other.eqStudyId))) {
            return false;
        }
        if ((this.eqLocationId == null && other.eqLocationId != null) || (this.eqLocationId != null && !this.eqLocationId.equals(other.eqLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyLocationMapPK[ eqStudyId=" + eqStudyId + ", eqLocationId=" + eqLocationId + " ]";
    }
    
}
