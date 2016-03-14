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
public class StudyUserMapPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Basic(optional = false)
    @Column(name = "EQ_USER_ID")
    private String eqUserId;

    public StudyUserMapPK() {
    }

    public StudyUserMapPK(String eqStudyId, String eqUserId) {
        this.eqStudyId = eqStudyId;
        this.eqUserId = eqUserId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqUserId() {
        return eqUserId;
    }

    public void setEqUserId(String eqUserId) {
        this.eqUserId = eqUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqStudyId != null ? eqStudyId.hashCode() : 0);
        hash += (eqUserId != null ? eqUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyUserMapPK)) {
            return false;
        }
        StudyUserMapPK other = (StudyUserMapPK) object;
        if ((this.eqStudyId == null && other.eqStudyId != null) || (this.eqStudyId != null && !this.eqStudyId.equals(other.eqStudyId))) {
            return false;
        }
        if ((this.eqUserId == null && other.eqUserId != null) || (this.eqUserId != null && !this.eqUserId.equals(other.eqUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyUserMapPK[ eqStudyId=" + eqStudyId + ", eqUserId=" + eqUserId + " ]";
    }
    
}
