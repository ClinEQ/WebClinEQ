/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "STUDIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studies.findAll", query = "SELECT s FROM Studies s"),
    @NamedQuery(name = "Studies.findByEqStudyId", query = "SELECT s FROM Studies s WHERE s.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "Studies.findByEqCoSponId", query = "SELECT s FROM Studies s WHERE s.eqCoSponId = :eqCoSponId"),
    @NamedQuery(name = "Studies.findByNctid", query = "SELECT s FROM Studies s WHERE s.nctid = :nctid"),
    @NamedQuery(name = "Studies.findByEuStudyId", query = "SELECT s FROM Studies s WHERE s.euStudyId = :euStudyId"),
    @NamedQuery(name = "Studies.findByStudyAname", query = "SELECT s FROM Studies s WHERE s.studyAname = :studyAname"),
    @NamedQuery(name = "Studies.findByStudyTitle", query = "SELECT s FROM Studies s WHERE s.studyTitle = :studyTitle"),
    @NamedQuery(name = "Studies.findBySponStudyId", query = "SELECT s FROM Studies s WHERE s.sponStudyId = :sponStudyId"),
    @NamedQuery(name = "Studies.findByCoSponStudyId", query = "SELECT s FROM Studies s WHERE s.coSponStudyId = :coSponStudyId"),
    @NamedQuery(name = "Studies.findByStudyStartDate", query = "SELECT s FROM Studies s WHERE s.studyStartDate = :studyStartDate"),
    @NamedQuery(name = "Studies.findByStudyEndDate", query = "SELECT s FROM Studies s WHERE s.studyEndDate = :studyEndDate"),
    @NamedQuery(name = "Studies.findByStudyEqInitDate", query = "SELECT s FROM Studies s WHERE s.studyEqInitDate = :studyEqInitDate"),
    @NamedQuery(name = "Studies.findByStudyEqCloseDate", query = "SELECT s FROM Studies s WHERE s.studyEqCloseDate = :studyEqCloseDate"),
    @NamedQuery(name = "Studies.findByPlannedPatientsNum", query = "SELECT s FROM Studies s WHERE s.plannedPatientsNum = :plannedPatientsNum"),
    @NamedQuery(name = "Studies.findByStudyStatus", query = "SELECT s FROM Studies s WHERE s.studyStatus = :studyStatus")})
public class Studies implements Serializable {

    @Column(name = "PLANNED_PATIENTS_NUM")
    private int plannedPatientsNum;
    @JoinColumn(name = "EQ_MANAGER_ID", referencedColumnName = "EQ_USER_ID")
    @ManyToOne
    private Users eqManagerId;

    @JoinColumn(name = "SPON_STUDY_MANAGER_ID", referencedColumnName = "EQ_USER_ID")
    @ManyToOne
    private Users sponStudyManagerId;

    @Size(max = 30)
    @Column(name = "CHART_GROUP_ID")
    private String chartGroupId;
    @OneToMany(mappedBy = "eqStudyId")
    private Collection<StudyChartCategory> studyChartCategoryCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Column(name = "EQ_CO_SPON_ID")
    private String eqCoSponId;
    @Column(name = "NCTID")
    private String nctid;
    @Column(name = "EU_STUDY_ID")
    private String euStudyId;
    @Column(name = "STUDY_ANAME")
    private String studyAname;
    @Column(name = "STUDY_TITLE")
    private String studyTitle;
    @Column(name = "SPON_STUDY_ID")
    private String sponStudyId;
    @Column(name = "CO_SPON_STUDY_ID")
    private String coSponStudyId;
    @Column(name = "STUDY_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date studyStartDate;
    @Column(name = "STUDY_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date studyEndDate;
    @Column(name = "STUDY_EQ_INIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date studyEqInitDate;
    @Column(name = "STUDY_EQ_CLOSE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date studyEqCloseDate;
    @Column(name = "STUDY_STATUS")
    private String studyStatus;
    @OneToMany(mappedBy = "eqStudyId")
    private Collection<Subjects> subjectsCollection;
    @JoinColumn(name = "EQ_SPON_ID", referencedColumnName = "EQ_ORG_ID")
    @ManyToOne
    private String eqSponId;
    @JoinColumn(name = "EQ_IWRS_ID", referencedColumnName = "EQ_ORG_ID")
    @ManyToOne
    private String eqIwrsId;
    @JoinColumn(name = "CHART_GROUP_ID", referencedColumnName = "CHART_GROUP_ID")
    @ManyToOne
    //private String chartGroupId;
    //@JoinColumn(name = "SPON_STUDY_MANAGER_ID", referencedColumnName = "EQ_USER_ID")
    //@ManyToOne
    //private Users sponStudyManagerId;
    //@JoinColumn(name = "EQ_MANAGER_ID", referencedColumnName = "EQ_USER_ID")
    //@ManyToOne
    //private Users eqManagerId;
    @OneToMany(mappedBy = "eqStudyId")
    //private Collection<StudyChartGroup> studyChartGroupCollection;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "studies")
    private Collection<StudySubjectMap> studySubjectMapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studies")
    private Collection<StudyUserMap> studyUserMapCollection;
    @OneToMany(mappedBy = "eqStudyId")
    private Collection<OrgDocUpldRegistry> orgDocUpldRegistryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studies")
    private Collection<StudyLocationMap> studyLocationMapCollection;

    private String eqSponName;
    
    private String eqUserName; 

    public Studies() {
    }

    public Studies(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getEqCoSponId() {
        return eqCoSponId;
    }

    public void setEqCoSponId(String eqCoSponId) {
        this.eqCoSponId = eqCoSponId;
    }

    public String getNctid() {
        return nctid;
    }

    public void setNctid(String nctid) {
        this.nctid = nctid;
    }

    public String getEuStudyId() {
        return euStudyId;
    }

    public void setEuStudyId(String euStudyId) {
        this.euStudyId = euStudyId;
    }

    public String getStudyAname() {
        return studyAname;
    }

    public void setStudyAname(String studyAname) {
        this.studyAname = studyAname;
    }

    public String getStudyTitle() {
        return studyTitle;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

    public String getSponStudyId() {
        return sponStudyId;
    }

    public void setSponStudyId(String sponStudyId) {
        this.sponStudyId = sponStudyId;
    }

    public String getCoSponStudyId() {
        return coSponStudyId;
    }

    public void setCoSponStudyId(String coSponStudyId) {
        this.coSponStudyId = coSponStudyId;
    }

    public Date getStudyStartDate() {
        return studyStartDate;
    }

    public void setStudyStartDate(Date studyStartDate) {
        this.studyStartDate = studyStartDate;
    }

    public Date getStudyEndDate() {
        return studyEndDate;
    }

    public void setStudyEndDate(Date studyEndDate) {
        this.studyEndDate = studyEndDate;
    }

    public Date getStudyEqInitDate() {
        return studyEqInitDate;
    }

    public void setStudyEqInitDate(Date studyEqInitDate) {
        this.studyEqInitDate = studyEqInitDate;
    }

    public Date getStudyEqCloseDate() {
        return studyEqCloseDate;
    }

    public void setStudyEqCloseDate(Date studyEqCloseDate) {
        this.studyEqCloseDate = studyEqCloseDate;
    }

    public int getPlannedPatientsNum() {
        return plannedPatientsNum;
    }

    public void setPlannedPatientsNum(int  plannedPatientsNum) {
        this.plannedPatientsNum = plannedPatientsNum;
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(String studyStatus) {
        this.studyStatus = studyStatus;
    }

    @XmlTransient
    public Collection<Subjects> getSubjectsCollection() {
        return subjectsCollection;
    }

    public void setSubjectsCollection(Collection<Subjects> subjectsCollection) {
        this.subjectsCollection = subjectsCollection;
    }

    public String getEqSponId() {
        return eqSponId;
    }

    public void setEqSponId(String eqSponId) {
        this.eqSponId = eqSponId;
    }
 
   
     public String getEqUserName() {
        return eqUserName;
    }

    public void setEqUserName(String eqUserName) {
        this.eqUserName = eqUserName;
    }
    
       public String getEqSponName() {
        return eqSponName;
    }

    public void setEqSponName(String eqSponName) {
        this.eqSponName = eqSponName;
    }

    public String getEqIwrsId() {
        return eqIwrsId;
    }

    public void setEqIwrsId(String eqIwrsId) {
        this.eqIwrsId = eqIwrsId;
    }

    public String getChartGroupId() {
        return chartGroupId;
    }

    public void setChartGroupId(String chartGroupId) {
        this.chartGroupId = chartGroupId;
    }

    public Users getSponStudyManagerId() {
        return sponStudyManagerId;
    }

    public void setSponStudyManagerId(Users sponStudyManagerId) {
        this.sponStudyManagerId = sponStudyManagerId;
    }

    public Users getEqManagerId() {
        return eqManagerId;
    }

    public void setEqManagerId(Users eqManagerId) {
        this.eqManagerId = eqManagerId;
    }

   /* @XmlTransient
    public Collection<StudyChartGroup> getStudyChartGroupCollection() {
        return studyChartGroupCollection;
    }

    public void setStudyChartGroupCollection(Collection<StudyChartGroup> studyChartGroupCollection) {
        this.studyChartGroupCollection = studyChartGroupCollection;
    }*/

    @XmlTransient
    public Collection<StudySubjectMap> getStudySubjectMapCollection() {
        return studySubjectMapCollection;
    }

    public void setStudySubjectMapCollection(Collection<StudySubjectMap> studySubjectMapCollection) {
        this.studySubjectMapCollection = studySubjectMapCollection;
    }

    @XmlTransient
    public Collection<StudyUserMap> getStudyUserMapCollection() {
        return studyUserMapCollection;
    }

    public void setStudyUserMapCollection(Collection<StudyUserMap> studyUserMapCollection) {
        this.studyUserMapCollection = studyUserMapCollection;
    }

    @XmlTransient
    public Collection<OrgDocUpldRegistry> getOrgDocUpldRegistryCollection() {
        return orgDocUpldRegistryCollection;
    }

    public void setOrgDocUpldRegistryCollection(Collection<OrgDocUpldRegistry> orgDocUpldRegistryCollection) {
        this.orgDocUpldRegistryCollection = orgDocUpldRegistryCollection;
    }

    @XmlTransient
    public Collection<StudyLocationMap> getStudyLocationMapCollection() {
        return studyLocationMapCollection;
    }

    public void setStudyLocationMapCollection(Collection<StudyLocationMap> studyLocationMapCollection) {
        this.studyLocationMapCollection = studyLocationMapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqStudyId != null ? eqStudyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studies)) {
            return false;
        }
        Studies other = (Studies) object;
        if ((this.eqStudyId == null && other.eqStudyId != null) || (this.eqStudyId != null && !this.eqStudyId.equals(other.eqStudyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.Studies[ eqStudyId=" + eqStudyId + " ]";
    }

 /*   public BigInteger getPlannedPatientsNum() {
        return plannedPatientsNum;
    }

    public void setPlannedPatientsNum(BigInteger plannedPatientsNum) {
        this.plannedPatientsNum = plannedPatientsNum;
    }*/

  /*  public String getChartGroupId() {
        return chartGroupId;
    }

    public void setChartGroupId(String chartGroupId) {
        this.chartGroupId = chartGroupId;
    }*/

    @XmlTransient
    public Collection<StudyChartCategory> getStudyChartCategoryCollection() {
        return studyChartCategoryCollection;
    }

    public void setStudyChartCategoryCollection(Collection<StudyChartCategory> studyChartCategoryCollection) {
        this.studyChartCategoryCollection = studyChartCategoryCollection;
    }

  /*  public Users getSponStudyManagerId() {
        return sponStudyManagerId;
    }

    public void setSponStudyManagerId(Users sponStudyManagerId) {
        this.sponStudyManagerId = sponStudyManagerId;
    }*/

 /*   public BigInteger getPlannedPatientsNum() {
        return plannedPatientsNum;
    }

    public void setPlannedPatientsNum(int plannedPatientsNum) {
        this.plannedPatientsNum = plannedPatientsNum;
    }*/

 /*   public Users getEqManagerId() {
        return eqManagerId;
    }

    public void setEqManagerId(Users eqManagerId) {
        this.eqManagerId = eqManagerId;
    }
*/

  /*  public BigInteger getPlannedPatientsNum() {
        return plannedPatientsNum;
    }

    public void setPlannedPatientsNum(BigInteger plannedPatientsNum) {
        this.plannedPatientsNum = plannedPatientsNum;
    }*/

 /*   public BigInteger getPlannedPatientsNum() {
        return plannedPatientsNum;
    }

    public void setPlannedPatientsNum(BigInteger plannedPatientsNum) {
        this.plannedPatientsNum = plannedPatientsNum;
    }*/
}
