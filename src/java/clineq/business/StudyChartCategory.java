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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "STUDY_CHART_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyChartCategory.findAll", query = "SELECT s FROM StudyChartCategory s"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategoryId", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategoryId = :chartCategoryId"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategoryName", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategoryName = :chartCategoryName"),
    @NamedQuery(name = "StudyChartCategory.findByStatus", query = "SELECT s FROM StudyChartCategory s WHERE s.status = :status"),
    @NamedQuery(name = "StudyChartCategory.findByLastUpdateDate", query = "SELECT s FROM StudyChartCategory s WHERE s.lastUpdateDate = :lastUpdateDate")})
public class StudyChartCategory implements Serializable {

    @OneToMany(mappedBy = "chartCategoryId")
    private Collection<StudyChartSubcategory> studyChartSubcategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyChartCategory")
    private Collection<SubjectCharts> subjectChartsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CHART_CATEGORY_ID")
    private String chartCategoryId;
    @Size(max = 50)
    @Column(name = "CHART_CATEGORY_NAME")
    private String chartCategoryName;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID")
    @ManyToOne
    private Studies eqStudyId;

    public StudyChartCategory() {
    }

    public StudyChartCategory(String chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    public String getChartCategoryId() {
        return chartCategoryId;
    }

    public void setChartCategoryId(String chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    public String getChartCategoryName() {
        return chartCategoryName;
    }

    public void setChartCategoryName(String chartCategoryName) {
        this.chartCategoryName = chartCategoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Studies getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(Studies eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chartCategoryId != null ? chartCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyChartCategory)) {
            return false;
        }
        StudyChartCategory other = (StudyChartCategory) object;
        if ((this.chartCategoryId == null && other.chartCategoryId != null) || (this.chartCategoryId != null && !this.chartCategoryId.equals(other.chartCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyChartCategory[ chartCategoryId=" + chartCategoryId + " ]";
    }

    @XmlTransient
    public Collection<StudyChartSubcategory> getStudyChartSubcategoryCollection() {
        return studyChartSubcategoryCollection;
    }

    public void setStudyChartSubcategoryCollection(Collection<StudyChartSubcategory> studyChartSubcategoryCollection) {
        this.studyChartSubcategoryCollection = studyChartSubcategoryCollection;
    }

    @XmlTransient
    public Collection<SubjectCharts> getSubjectChartsCollection() {
        return subjectChartsCollection;
    }

    public void setSubjectChartsCollection(Collection<SubjectCharts> subjectChartsCollection) {
        this.subjectChartsCollection = subjectChartsCollection;
    }
    
}
