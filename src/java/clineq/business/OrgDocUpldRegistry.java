/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ORG_DOC_UPLD_REGISTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgDocUpldRegistry.findAll", query = "SELECT o FROM OrgDocUpldRegistry o"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByOrgDocUploadId", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.orgDocUploadId = :orgDocUploadId"),
    @NamedQuery(name = "OrgDocUpldRegistry.findBySubjectChartCatagoryId", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.subjectChartCatagoryId = :subjectChartCatagoryId"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByChartSubcategoryId", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.chartSubcategoryId = :chartSubcategoryId"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByEqOrgId", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.eqOrgId = :eqOrgId"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByEqUserId", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.eqUserId = :eqUserId"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByUploadStartDate", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.uploadStartDate = :uploadStartDate"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByUploadEndDate", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.uploadEndDate = :uploadEndDate"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByUploadStatus", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.uploadStatus = :uploadStatus"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByRemoteIp", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.remoteIp = :remoteIp"),
    @NamedQuery(name = "OrgDocUpldRegistry.findByCertification", query = "SELECT o FROM OrgDocUpldRegistry o WHERE o.certification = :certification")})
public class OrgDocUpldRegistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ORG_DOC_UPLOAD_ID")
    private String orgDocUploadId;
    @Size(max = 30)
    @Column(name = "SUBJECT_CHART_CATAGORY_ID")
    private String subjectChartCatagoryId;
    @Size(max = 30)
    @Column(name = "CHART_SUBCATEGORY_ID")
    private String chartSubcategoryId;
    @Size(max = 30)
    @Column(name = "EQ_ORG_ID")
    private String eqOrgId;
    @Size(max = 30)
    @Column(name = "EQ_USER_ID")
    private String eqUserId;
    @Column(name = "UPLOAD_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadStartDate;
    @Column(name = "UPLOAD_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadEndDate;
    @Size(max = 30)
    @Column(name = "UPLOAD_STATUS")
    private String uploadStatus;
    @Size(max = 30)
    @Column(name = "REMOTE_IP")
    private String remoteIp;
    @Size(max = 1)
    @Column(name = "CERTIFICATION")
    private String certification;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID")
    @ManyToOne
    private Studies eqStudyId;
    @JoinColumn(name = "EQ_SUBJECT_ID", referencedColumnName = "EQ_SUBJECT_ID")
    @ManyToOne
    private Subjects eqSubjectId;

    public OrgDocUpldRegistry() {
    }

    public OrgDocUpldRegistry(String orgDocUploadId) {
        this.orgDocUploadId = orgDocUploadId;
    }

    public String getOrgDocUploadId() {
        return orgDocUploadId;
    }

    public void setOrgDocUploadId(String orgDocUploadId) {
        this.orgDocUploadId = orgDocUploadId;
    }

    public String getSubjectChartCatagoryId() {
        return subjectChartCatagoryId;
    }

    public void setSubjectChartCatagoryId(String subjectChartCatagoryId) {
        this.subjectChartCatagoryId = subjectChartCatagoryId;
    }

    public String getChartSubcategoryId() {
        return chartSubcategoryId;
    }

    public void setChartSubcategoryId(String chartSubcategoryId) {
        this.chartSubcategoryId = chartSubcategoryId;
    }

    public String getEqOrgId() {
        return eqOrgId;
    }

    public void setEqOrgId(String eqOrgId) {
        this.eqOrgId = eqOrgId;
    }

    public String getEqUserId() {
        return eqUserId;
    }

    public void setEqUserId(String eqUserId) {
        this.eqUserId = eqUserId;
    }

    public Date getUploadStartDate() {
        return uploadStartDate;
    }

    public void setUploadStartDate(Date uploadStartDate) {
        this.uploadStartDate = uploadStartDate;
    }

    public Date getUploadEndDate() {
        return uploadEndDate;
    }

    public void setUploadEndDate(Date uploadEndDate) {
        this.uploadEndDate = uploadEndDate;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Studies getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(Studies eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public Subjects getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(Subjects eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgDocUploadId != null ? orgDocUploadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgDocUpldRegistry)) {
            return false;
        }
        OrgDocUpldRegistry other = (OrgDocUpldRegistry) object;
        if ((this.orgDocUploadId == null && other.orgDocUploadId != null) || (this.orgDocUploadId != null && !this.orgDocUploadId.equals(other.orgDocUploadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.OrgDocUpldRegistry[ orgDocUploadId=" + orgDocUploadId + " ]";
    }
    
}
