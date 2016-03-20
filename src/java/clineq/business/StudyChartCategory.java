/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STUDY_CHART_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyChartCategory.findAll", query = "SELECT s FROM StudyChartCategory s"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategoryId", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategoryId = :chartCategoryId"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategoryName", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategoryName = :chartCategoryName"),
    @NamedQuery(name = "StudyChartCategory.findByChartType", query = "SELECT s FROM StudyChartCategory s WHERE s.chartType = :chartType"),
    @NamedQuery(name = "StudyChartCategory.findBySysCodeId", query = "SELECT s FROM StudyChartCategory s WHERE s.sysCodeId = :sysCodeId"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategorySeq", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategorySeq = :chartCategorySeq"),
    @NamedQuery(name = "StudyChartCategory.findByChartCategoryStatus", query = "SELECT s FROM StudyChartCategory s WHERE s.chartCategoryStatus = :chartCategoryStatus")})
public class StudyChartCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CHART_CATEGORY_ID")
    private String chartCategoryId;
    @Column(name = "CHART_CATEGORY_NAME")
    private String chartCategoryName;
    @Column(name = "CHART_TYPE")
    private String chartType;
    @Column(name = "SYS_CODE_ID")
    private String sysCodeId;
    @Column(name = "CHART_CATEGORY_SEQ")
    private BigInteger chartCategorySeq;
    @Column(name = "CHART_CATEGORY_STATUS")
    private String chartCategoryStatus;
    @JoinColumn(name = "CHART_GROUP_ID", referencedColumnName = "CHART_GROUP_ID")
    @ManyToOne
    private StudyChartGroup chartGroupId;

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

    public String getChartType() {
        return chartType;
    }

    public void setChartType(String chartType) {
        this.chartType = chartType;
    }

    public String getSysCodeId() {
        return sysCodeId;
    }

    public void setSysCodeId(String sysCodeId) {
        this.sysCodeId = sysCodeId;
    }

    public BigInteger getChartCategorySeq() {
        return chartCategorySeq;
    }

    public void setChartCategorySeq(BigInteger chartCategorySeq) {
        this.chartCategorySeq = chartCategorySeq;
    }

    public String getChartCategoryStatus() {
        return chartCategoryStatus;
    }

    public void setChartCategoryStatus(String chartCategoryStatus) {
        this.chartCategoryStatus = chartCategoryStatus;
    }

    public StudyChartGroup getChartGroupId() {
        return chartGroupId;
    }

    public void setChartGroupId(StudyChartGroup chartGroupId) {
        this.chartGroupId = chartGroupId;
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
    
}
