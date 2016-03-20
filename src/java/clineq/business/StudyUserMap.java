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
@Table(name = "STUDY_USER_MAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyUserMap.findAll", query = "SELECT s FROM StudyUserMap s"),
    @NamedQuery(name = "StudyUserMap.findByEqStudyId", query = "SELECT s FROM StudyUserMap s WHERE s.studyUserMapPK.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "StudyUserMap.findByEqUserId", query = "SELECT s FROM StudyUserMap s WHERE s.studyUserMapPK.eqUserId = :eqUserId"),
    @NamedQuery(name = "StudyUserMap.findByStatus", query = "SELECT s FROM StudyUserMap s WHERE s.status = :status")})
public class StudyUserMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudyUserMapPK studyUserMapPK;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studies studies;
    @JoinColumn(name = "EQ_USER_ID", referencedColumnName = "EQ_USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public StudyUserMap() {
    }

    public StudyUserMap(StudyUserMapPK studyUserMapPK) {
        this.studyUserMapPK = studyUserMapPK;
    }

    public StudyUserMap(String eqStudyId, String eqUserId) {
        this.studyUserMapPK = new StudyUserMapPK(eqStudyId, eqUserId);
    }

    public StudyUserMapPK getStudyUserMapPK() {
        return studyUserMapPK;
    }

    public void setStudyUserMapPK(StudyUserMapPK studyUserMapPK) {
        this.studyUserMapPK = studyUserMapPK;
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studyUserMapPK != null ? studyUserMapPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyUserMap)) {
            return false;
        }
        StudyUserMap other = (StudyUserMap) object;
        if ((this.studyUserMapPK == null && other.studyUserMapPK != null) || (this.studyUserMapPK != null && !this.studyUserMapPK.equals(other.studyUserMapPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyUserMap[ studyUserMapPK=" + studyUserMapPK + " ]";
    }
    
}
