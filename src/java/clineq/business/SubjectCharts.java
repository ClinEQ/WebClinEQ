/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "SUBJECT_CHARTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectCharts.findAll", query = "SELECT s FROM SubjectCharts s"),
    @NamedQuery(name = "SubjectCharts.findByUploadType", query = "SELECT s FROM SubjectCharts s WHERE s.uploadType = :uploadType"),
    @NamedQuery(name = "SubjectCharts.findByUploadSeq", query = "SELECT s FROM SubjectCharts s WHERE s.uploadSeq = :uploadSeq"),
    @NamedQuery(name = "SubjectCharts.findByUploadTimestamp", query = "SELECT s FROM SubjectCharts s WHERE s.uploadTimestamp = :uploadTimestamp"),
    @NamedQuery(name = "SubjectCharts.findByUploadId", query = "SELECT s FROM SubjectCharts s WHERE s.uploadId = :uploadId"),
    @NamedQuery(name = "SubjectCharts.findByDocName", query = "SELECT s FROM SubjectCharts s WHERE s.docName = :docName"),
    @NamedQuery(name = "SubjectCharts.findByDocVersion", query = "SELECT s FROM SubjectCharts s WHERE s.docVersion = :docVersion"),
    @NamedQuery(name = "SubjectCharts.findByReviewStatus", query = "SELECT s FROM SubjectCharts s WHERE s.reviewStatus = :reviewStatus"),
    @NamedQuery(name = "SubjectCharts.findByEqSubjectChartId", query = "SELECT s FROM SubjectCharts s WHERE s.eqSubjectChartId = :eqSubjectChartId")})
public class SubjectCharts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "UPLOAD_TYPE")
    private String uploadType;
    @Column(name = "UPLOAD_SEQ")
    private BigInteger uploadSeq;
    @Column(name = "UPLOAD_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadTimestamp;
    @Size(max = 30)
    @Column(name = "UPLOAD_ID")
    private String uploadId;
    @Size(max = 50)
    @Column(name = "DOC_NAME")
    private String docName;
    @Size(max = 30)
    @Column(name = "DOC_VERSION")
    private String docVersion;
    @Lob
    @Column(name = "DOC_CONTENT")
    private Serializable docContent;
    @Size(max = 50)
    @Column(name = "REVIEW_STATUS")
    private String reviewStatus;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EQ_SUBJECT_CHART_ID")
    private String eqSubjectChartId;
    @JoinColumn(name = "CHART_CATEGORY_ID", referencedColumnName = "CHART_CATEGORY_ID")
    @ManyToOne
    private StudyChartCategory chartCategoryId;
    @JoinColumn(name = "CHART_SUBCATEGORY_ID", referencedColumnName = "CHART_SUBCATEGORY_ID")
    @ManyToOne
    private StudyChartSubcategory chartSubcategoryId;
    @JoinColumn(name = "EQ_SUBJECT_ID", referencedColumnName = "EQ_SUBJECT_ID")
    @ManyToOne
    private Subjects eqSubjectId;

    public SubjectCharts() {
    }

    public SubjectCharts(String eqSubjectChartId) {
        this.eqSubjectChartId = eqSubjectChartId;
    }

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }

    public BigInteger getUploadSeq() {
        return uploadSeq;
    }

    public void setUploadSeq(BigInteger uploadSeq) {
        this.uploadSeq = uploadSeq;
    }

    public Date getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(Date uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocVersion() {
        return docVersion;
    }

    public void setDocVersion(String docVersion) {
        this.docVersion = docVersion;
    }

    public Serializable getDocContent() {
        return docContent;
    }

    public void setDocContent(Serializable docContent) {
        this.docContent = docContent;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getEqSubjectChartId() {
        return eqSubjectChartId;
    }

    public void setEqSubjectChartId(String eqSubjectChartId) {
        this.eqSubjectChartId = eqSubjectChartId;
    }

    public StudyChartCategory getChartCategoryId() {
        return chartCategoryId;
    }

    public void setChartCategoryId(StudyChartCategory chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    public StudyChartSubcategory getChartSubcategoryId() {
        return chartSubcategoryId;
    }

    public void setChartSubcategoryId(StudyChartSubcategory chartSubcategoryId) {
        this.chartSubcategoryId = chartSubcategoryId;
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
        hash += (eqSubjectChartId != null ? eqSubjectChartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectCharts)) {
            return false;
        }
        SubjectCharts other = (SubjectCharts) object;
        if ((this.eqSubjectChartId == null && other.eqSubjectChartId != null) || (this.eqSubjectChartId != null && !this.eqSubjectChartId.equals(other.eqSubjectChartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SubjectCharts[ eqSubjectChartId=" + eqSubjectChartId + " ]";
    }
    
}
