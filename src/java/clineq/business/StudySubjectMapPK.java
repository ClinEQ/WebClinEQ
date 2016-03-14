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
public class StudySubjectMapPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Basic(optional = false)
    @Column(name = "EQ_SUBJECT_ID")
    private String eqSubjectId;

    public StudySubjectMapPK() {
    }

    public StudySubjectMapPK(String eqStudyId, String eqSubjectId) {
        this.eqStudyId = eqStudyId;
        this.eqSubjectId = eqSubjectId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(String eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqStudyId != null ? eqStudyId.hashCode() : 0);
        hash += (eqSubjectId != null ? eqSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudySubjectMapPK)) {
            return false;
        }
        StudySubjectMapPK other = (StudySubjectMapPK) object;
        if ((this.eqStudyId == null && other.eqStudyId != null) || (this.eqStudyId != null && !this.eqStudyId.equals(other.eqStudyId))) {
            return false;
        }
        if ((this.eqSubjectId == null && other.eqSubjectId != null) || (this.eqSubjectId != null && !this.eqSubjectId.equals(other.eqSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudySubjectMapPK[ eqStudyId=" + eqStudyId + ", eqSubjectId=" + eqSubjectId + " ]";
    }
    
}
