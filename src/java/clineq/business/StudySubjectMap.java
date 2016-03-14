/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "STUDY_SUBJECT_MAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudySubjectMap.findAll", query = "SELECT s FROM StudySubjectMap s"),
    @NamedQuery(name = "StudySubjectMap.findByEqStudyId", query = "SELECT s FROM StudySubjectMap s WHERE s.studySubjectMapPK.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "StudySubjectMap.findByEqSubjectId", query = "SELECT s FROM StudySubjectMap s WHERE s.studySubjectMapPK.eqSubjectId = :eqSubjectId"),
    @NamedQuery(name = "StudySubjectMap.findByStatus", query = "SELECT s FROM StudySubjectMap s WHERE s.status = :status")})
public class StudySubjectMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudySubjectMapPK studySubjectMapPK;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studies studies;
    @JoinColumn(name = "EQ_SUBJECT_ID", referencedColumnName = "EQ_SUBJECT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subjects subjects;

    public StudySubjectMap() {
    }

    public StudySubjectMap(StudySubjectMapPK studySubjectMapPK) {
        this.studySubjectMapPK = studySubjectMapPK;
    }

    public StudySubjectMap(String eqStudyId, String eqSubjectId) {
        this.studySubjectMapPK = new StudySubjectMapPK(eqStudyId, eqSubjectId);
    }

    public StudySubjectMapPK getStudySubjectMapPK() {
        return studySubjectMapPK;
    }

    public void setStudySubjectMapPK(StudySubjectMapPK studySubjectMapPK) {
        this.studySubjectMapPK = studySubjectMapPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studySubjectMapPK != null ? studySubjectMapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudySubjectMap)) {
            return false;
        }
        StudySubjectMap other = (StudySubjectMap) object;
        if ((this.studySubjectMapPK == null && other.studySubjectMapPK != null) || (this.studySubjectMapPK != null && !this.studySubjectMapPK.equals(other.studySubjectMapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudySubjectMap[ studySubjectMapPK=" + studySubjectMapPK + " ]";
    }
    
}
