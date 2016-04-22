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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Embeddable
public class SubjectChartsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EQ_SUBJECT_ID")
    private String eqSubjectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CHART_CATEGORY_ID")
    private String chartCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CHART_SUBCATEGORY_ID")
    private String chartSubcategoryId;

    public SubjectChartsPK() {
    }

    public SubjectChartsPK(String eqSubjectId, String chartCategoryId, String chartSubcategoryId) {
        this.eqSubjectId = eqSubjectId;
        this.chartCategoryId = chartCategoryId;
        this.chartSubcategoryId = chartSubcategoryId;
    }

    public String getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(String eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    public String getChartCategoryId() {
        return chartCategoryId;
    }

    public void setChartCategoryId(String chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    public String getChartSubcategoryId() {
        return chartSubcategoryId;
    }

    public void setChartSubcategoryId(String chartSubcategoryId) {
        this.chartSubcategoryId = chartSubcategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqSubjectId != null ? eqSubjectId.hashCode() : 0);
        hash += (chartCategoryId != null ? chartCategoryId.hashCode() : 0);
        hash += (chartSubcategoryId != null ? chartSubcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectChartsPK)) {
            return false;
        }
        SubjectChartsPK other = (SubjectChartsPK) object;
        if ((this.eqSubjectId == null && other.eqSubjectId != null) || (this.eqSubjectId != null && !this.eqSubjectId.equals(other.eqSubjectId))) {
            return false;
        }
        if ((this.chartCategoryId == null && other.chartCategoryId != null) || (this.chartCategoryId != null && !this.chartCategoryId.equals(other.chartCategoryId))) {
            return false;
        }
        if ((this.chartSubcategoryId == null && other.chartSubcategoryId != null) || (this.chartSubcategoryId != null && !this.chartSubcategoryId.equals(other.chartSubcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SubjectChartsPK[ eqSubjectId=" + eqSubjectId + ", chartCategoryId=" + chartCategoryId + ", chartSubcategoryId=" + chartSubcategoryId + " ]";
    }
    
}
