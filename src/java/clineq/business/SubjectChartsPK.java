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

/**
 *
 * @author Elijah
 */
@Embeddable
public class SubjectChartsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_SUBJECT_ID")
    private String eqSubjectId;
    @Basic(optional = false)
    @Column(name = "CHART_GROUP_ID")
    private String chartGroupId;
    @Basic(optional = false)
    @Column(name = "CHART_CATEGORY_ID")
    private String chartCategoryId;

    public SubjectChartsPK() {
    }

    public SubjectChartsPK(String eqSubjectId, String chartGroupId, String chartCategoryId) {
        this.eqSubjectId = eqSubjectId;
        this.chartGroupId = chartGroupId;
        this.chartCategoryId = chartCategoryId;
    }

    public String getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(String eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    public String getChartGroupId() {
        return chartGroupId;
    }

    public void setChartGroupId(String chartGroupId) {
        this.chartGroupId = chartGroupId;
    }

    public String getChartCategoryId() {
        return chartCategoryId;
    }

    public void setChartCategoryId(String chartCategoryId) {
        this.chartCategoryId = chartCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqSubjectId != null ? eqSubjectId.hashCode() : 0);
        hash += (chartGroupId != null ? chartGroupId.hashCode() : 0);
        hash += (chartCategoryId != null ? chartCategoryId.hashCode() : 0);
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
        if ((this.chartGroupId == null && other.chartGroupId != null) || (this.chartGroupId != null && !this.chartGroupId.equals(other.chartGroupId))) {
            return false;
        }
        if ((this.chartCategoryId == null && other.chartCategoryId != null) || (this.chartCategoryId != null && !this.chartCategoryId.equals(other.chartCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SubjectChartsPK[ eqSubjectId=" + eqSubjectId + ", chartGroupId=" + chartGroupId + ", chartCategoryId=" + chartCategoryId + " ]";
    }
    
}
