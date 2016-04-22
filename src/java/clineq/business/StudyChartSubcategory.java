/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "STUDY_CHART_SUBCATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyChartSubcategory.findAll", query = "SELECT s FROM StudyChartSubcategory s"),
    @NamedQuery(name = "StudyChartSubcategory.findByChartSubcategoryId", query = "SELECT s FROM StudyChartSubcategory s WHERE s.chartSubcategoryId = :chartSubcategoryId"),
    @NamedQuery(name = "StudyChartSubcategory.findByChartSubcategoryName", query = "SELECT s FROM StudyChartSubcategory s WHERE s.chartSubcategoryName = :chartSubcategoryName"),
    @NamedQuery(name = "StudyChartSubcategory.findByChartType", query = "SELECT s FROM StudyChartSubcategory s WHERE s.chartType = :chartType"),
    @NamedQuery(name = "StudyChartSubcategory.findByChartSubcategorySeq", query = "SELECT s FROM StudyChartSubcategory s WHERE s.chartSubcategorySeq = :chartSubcategorySeq"),
    @NamedQuery(name = "StudyChartSubcategory.findByChartSubcategoryStatus", query = "SELECT s FROM StudyChartSubcategory s WHERE s.chartSubcategoryStatus = :chartSubcategoryStatus")})
public class StudyChartSubcategory implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyChartSubcategory")
    private Collection<SubjectCharts> subjectChartsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CHART_SUBCATEGORY_ID")
    private String chartSubcategoryId;
    @Size(max = 50)
    @Column(name = "CHART_SUBCATEGORY_NAME")
    private String chartSubcategoryName;
    @Size(max = 30)
    @Column(name = "CHART_TYPE")
    private String chartType;
    @Column(name = "CHART_SUBCATEGORY_SEQ")
    private int chartSubcategorySeq;
    @Size(max = 30)
    @Column(name = "CHART_SUBCATEGORY_STATUS")
    private String chartSubcategoryStatus;
    @JoinColumn(name = "CHART_CATEGORY_ID", referencedColumnName = "CHART_CATEGORY_ID")
    @ManyToOne
    private StudyChartCategory chartCategoryId;

    public StudyChartSubcategory() {
    }

    public StudyChartSubcategory(String chartSubcategoryId) {
        this.chartSubcategoryId = chartSubcategoryId;
    }

    public String getChartSubcategoryId() {
        return chartSubcategoryId;
    }

    public void setChartSubcategoryId(String chartSubcategoryId) {
        this.chartSubcategoryId = chartSubcategoryId;
    }

    public String getChartSubcategoryName() {
        return chartSubcategoryName;
    }

    public void setChartSubcategoryName(String chartSubcategoryName) {
        this.chartSubcategoryName = chartSubcategoryName;
    }

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public int getChartSubcategorySeq() {
        return chartSubcategorySeq;
    }

    public void setChartSubcategorySeq(int chartSubcategorySeq) {
        this.chartSubcategorySeq = chartSubcategorySeq;
    }

    public String getChartSubcategoryStatus() {
        return chartSubcategoryStatus;
    }

    public void setChartSubcategoryStatus(String chartSubcategoryStatus) {
        this.chartSubcategoryStatus = chartSubcategoryStatus;
    }

    public StudyChartCategory getChartCategoryId() {
        return chartCategoryId;
    }

    public void setChartCategoryId(StudyChartCategory chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chartSubcategoryId != null ? chartSubcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyChartSubcategory)) {
            return false;
        }
        StudyChartSubcategory other = (StudyChartSubcategory) object;
        if ((this.chartSubcategoryId == null && other.chartSubcategoryId != null) || (this.chartSubcategoryId != null && !this.chartSubcategoryId.equals(other.chartSubcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyChartSubcategory[ chartSubcategoryId=" + chartSubcategoryId + " ]";
    }

    @XmlTransient
    public Collection<SubjectCharts> getSubjectChartsCollection() {
        return subjectChartsCollection;
    }

    public void setSubjectChartsCollection(Collection<SubjectCharts> subjectChartsCollection) {
        this.subjectChartsCollection = subjectChartsCollection;
    }
    
}
