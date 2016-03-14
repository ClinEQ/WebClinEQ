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
@Table(name = "STUDY_LOCATION_MAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyLocationMap.findAll", query = "SELECT s FROM StudyLocationMap s"),
    @NamedQuery(name = "StudyLocationMap.findByEqStudyId", query = "SELECT s FROM StudyLocationMap s WHERE s.studyLocationMapPK.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "StudyLocationMap.findByEqLocationId", query = "SELECT s FROM StudyLocationMap s WHERE s.studyLocationMapPK.eqLocationId = :eqLocationId"),
    @NamedQuery(name = "StudyLocationMap.findByNotes", query = "SELECT s FROM StudyLocationMap s WHERE s.notes = :notes")})
public class StudyLocationMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudyLocationMapPK studyLocationMapPK;
    @Column(name = "NOTES")
    private String notes;
    @JoinColumn(name = "EQ_LOCATION_ID", referencedColumnName = "EQ_LOCATION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SiteLocations siteLocations;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studies studies;

    public StudyLocationMap() {
    }

    public StudyLocationMap(StudyLocationMapPK studyLocationMapPK) {
        this.studyLocationMapPK = studyLocationMapPK;
    }

    public StudyLocationMap(String eqStudyId, String eqLocationId) {
        this.studyLocationMapPK = new StudyLocationMapPK(eqStudyId, eqLocationId);
    }

    public StudyLocationMapPK getStudyLocationMapPK() {
        return studyLocationMapPK;
    }

    public void setStudyLocationMapPK(StudyLocationMapPK studyLocationMapPK) {
        this.studyLocationMapPK = studyLocationMapPK;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public SiteLocations getSiteLocations() {
        return siteLocations;
    }

    public void setSiteLocations(SiteLocations siteLocations) {
        this.siteLocations = siteLocations;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studyLocationMapPK != null ? studyLocationMapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyLocationMap)) {
            return false;
        }
        StudyLocationMap other = (StudyLocationMap) object;
        if ((this.studyLocationMapPK == null && other.studyLocationMapPK != null) || (this.studyLocationMapPK != null && !this.studyLocationMapPK.equals(other.studyLocationMapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyLocationMap[ studyLocationMapPK=" + studyLocationMapPK + " ]";
    }
    
}
