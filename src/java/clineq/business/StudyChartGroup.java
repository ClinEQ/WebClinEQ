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
@Table(name = "STUDY_CHART_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudyChartGroup.findAll", query = "SELECT s FROM StudyChartGroup s"),
    @NamedQuery(name = "StudyChartGroup.findByChartGroupId", query = "SELECT s FROM StudyChartGroup s WHERE s.chartGroupId = :chartGroupId"),
    @NamedQuery(name = "StudyChartGroup.findByChartGroupName", query = "SELECT s FROM StudyChartGroup s WHERE s.chartGroupName = :chartGroupName"),
    @NamedQuery(name = "StudyChartGroup.findByStatus", query = "SELECT s FROM StudyChartGroup s WHERE s.status = :status"),
    @NamedQuery(name = "StudyChartGroup.findByLastUpdateDate", query = "SELECT s FROM StudyChartGroup s WHERE s.lastUpdateDate = :lastUpdateDate")})
public class StudyChartGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CHART_GROUP_ID")
    private String chartGroupId;
    @Column(name = "CHART_GROUP_NAME")
    private String chartGroupName;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(mappedBy = "chartGroupId")
    private Collection<Studies> studiesCollection;
    @OneToMany(mappedBy = "chartGroupId")
    private Collection<StudyChartCategory> studyChartCategoryCollection;
    @JoinColumn(name = "EQ_STUDY_ID", referencedColumnName = "EQ_STUDY_ID")
    @ManyToOne
    private Studies eqStudyId;

    public StudyChartGroup() {
    }

    public StudyChartGroup(String chartGroupId) {
        this.chartGroupId = chartGroupId;
    }

    public String getChartGroupId() {
        return chartGroupId;
    }

    public void setChartGroupId(String chartGroupId) {
        this.chartGroupId = chartGroupId;
    }

    public String getChartGroupName() {
        return chartGroupName;
    }

    public void setChartGroupName(String chartGroupName) {
        this.chartGroupName = chartGroupName;
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

    @XmlTransient
    public Collection<Studies> getStudiesCollection() {
        return studiesCollection;
    }

    public void setStudiesCollection(Collection<Studies> studiesCollection) {
        this.studiesCollection = studiesCollection;
    }

    @XmlTransient
    public Collection<StudyChartCategory> getStudyChartCategoryCollection() {
        return studyChartCategoryCollection;
    }

    public void setStudyChartCategoryCollection(Collection<StudyChartCategory> studyChartCategoryCollection) {
        this.studyChartCategoryCollection = studyChartCategoryCollection;
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
        hash += (chartGroupId != null ? chartGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudyChartGroup)) {
            return false;
        }
        StudyChartGroup other = (StudyChartGroup) object;
        if ((this.chartGroupId == null && other.chartGroupId != null) || (this.chartGroupId != null && !this.chartGroupId.equals(other.chartGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.StudyChartGroup[ chartGroupId=" + chartGroupId + " ]";
    }
    
}
