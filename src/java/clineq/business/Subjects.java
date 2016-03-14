/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "SUBJECTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s"),
    @NamedQuery(name = "Subjects.findByEqSubjectId", query = "SELECT s FROM Subjects s WHERE s.eqSubjectId = :eqSubjectId"),
    @NamedQuery(name = "Subjects.findBySponSubjectId", query = "SELECT s FROM Subjects s WHERE s.sponSubjectId = :sponSubjectId"),
    @NamedQuery(name = "Subjects.findByDateBirth", query = "SELECT s FROM Subjects s WHERE s.dateBirth = :dateBirth"),
    @NamedQuery(name = "Subjects.findByGender", query = "SELECT s FROM Subjects s WHERE s.gender = :gender"),
    @NamedQuery(name = "Subjects.findByLastUpdateDate", query = "SELECT s FROM Subjects s WHERE s.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "Subjects.findByLastUpdateId", query = "SELECT s FROM Subjects s WHERE s.lastUpdateId = :lastUpdateId"),
    @NamedQuery(name = "Subjects.findByDeleteflag", query = "SELECT s FROM Subjects s WHERE s.deleteflag = :deleteflag"),
    @NamedQuery(name = "Subjects.findByDeleteby", query = "SELECT s FROM Subjects s WHERE s.deleteby = :deleteby"),
    @NamedQuery(name = "Subjects.findByDeleteDate", query = "SELECT s FROM Subjects s WHERE s.deleteDate = :deleteDate"),
    @NamedQuery(name = "Subjects.findBySubjectStatus", query = "SELECT s FROM Subjects s WHERE s.subjectStatus = :subjectStatus")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EQ_SUBJECT_ID")
    private String eqSubjectId;
    @Column(name = "SPON_SUBJECT_ID")
    private String sponSubjectId;
    @Column(name = "DATE_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBirth;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "LAST_UPDATE_ID")
    private String lastUpdateId;
    @Column(name = "DELETEFLAG")
    private String deleteflag;
    @Column(name = "DELETEBY")
    private String deleteby;
    @Column(name = "DELETE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleteDate;
    @Column(name = "SUBJECT_STATUS")
    private String subjectStatus;
    @JoinColumn(name = "EQ_SITE_ID", referencedColumnName = "EQ_ORG_ID")
    @ManyToOne
    private Organizations eqSiteId;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID")
    @ManyToOne
    private Studies eqStudyId;
    @OneToMany(mappedBy = "eqSubjectId")
    private Collection<Messags> messagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
    private Collection<StudySubjectMap> studySubjectMapCollection;
    @OneToMany(mappedBy = "eqSubjectId")
    private Collection<OrgDocUpldRegistry> orgDocUpldRegistryCollection;

    public Subjects() {
    }

    public Subjects(String eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    public String getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(String eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    public String getSponSubjectId() {
        return sponSubjectId;
    }

    public void setSponSubjectId(String sponSubjectId) {
        this.sponSubjectId = sponSubjectId;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public Organizations getEqSiteId() {
        return eqSiteId;
    }

    public void setEqSiteId(Organizations eqSiteId) {
        this.eqSiteId = eqSiteId;
    }

    public Studies getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(Studies eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    @XmlTransient
    public Collection<Messags> getMessagsCollection() {
        return messagsCollection;
    }

    public void setMessagsCollection(Collection<Messags> messagsCollection) {
        this.messagsCollection = messagsCollection;
    }

    @XmlTransient
    public Collection<StudySubjectMap> getStudySubjectMapCollection() {
        return studySubjectMapCollection;
    }

    public void setStudySubjectMapCollection(Collection<StudySubjectMap> studySubjectMapCollection) {
        this.studySubjectMapCollection = studySubjectMapCollection;
    }

    @XmlTransient
    public Collection<OrgDocUpldRegistry> getOrgDocUpldRegistryCollection() {
        return orgDocUpldRegistryCollection;
    }

    public void setOrgDocUpldRegistryCollection(Collection<OrgDocUpldRegistry> orgDocUpldRegistryCollection) {
        this.orgDocUpldRegistryCollection = orgDocUpldRegistryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqSubjectId != null ? eqSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.eqSubjectId == null && other.eqSubjectId != null) || (this.eqSubjectId != null && !this.eqSubjectId.equals(other.eqSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.Subjects[ eqSubjectId=" + eqSubjectId + " ]";
    }
    
}
