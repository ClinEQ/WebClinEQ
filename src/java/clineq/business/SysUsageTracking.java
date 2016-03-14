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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "SYS_USAGE_TRACKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUsageTracking.findAll", query = "SELECT s FROM SysUsageTracking s"),
    @NamedQuery(name = "SysUsageTracking.findByTrackingId", query = "SELECT s FROM SysUsageTracking s WHERE s.trackingId = :trackingId"),
    @NamedQuery(name = "SysUsageTracking.findByStartDate", query = "SELECT s FROM SysUsageTracking s WHERE s.startDate = :startDate"),
    @NamedQuery(name = "SysUsageTracking.findByEndDate", query = "SELECT s FROM SysUsageTracking s WHERE s.endDate = :endDate"),
    @NamedQuery(name = "SysUsageTracking.findByOperationUsed", query = "SELECT s FROM SysUsageTracking s WHERE s.operationUsed = :operationUsed"),
    @NamedQuery(name = "SysUsageTracking.findByOperationDetail", query = "SELECT s FROM SysUsageTracking s WHERE s.operationDetail = :operationDetail"),
    @NamedQuery(name = "SysUsageTracking.findByRemoteDeviceIp", query = "SELECT s FROM SysUsageTracking s WHERE s.remoteDeviceIp = :remoteDeviceIp")})
public class SysUsageTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRACKING_ID")
    private String trackingId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "OPERATION_USED")
    private String operationUsed;
    @Column(name = "OPERATION_DETAIL")
    private String operationDetail;
    @Column(name = "REMOTE_DEVICE_IP")
    private String remoteDeviceIp;
    @JoinColumn(name = "EQ_USER_UNIQUE_ID", referencedColumnName = "EQ_USER_ID")
    @ManyToOne
    private Users eqUserUniqueId;

    public SysUsageTracking() {
    }

    public SysUsageTracking(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOperationUsed() {
        return operationUsed;
    }

    public void setOperationUsed(String operationUsed) {
        this.operationUsed = operationUsed;
    }

    public String getOperationDetail() {
        return operationDetail;
    }

    public void setOperationDetail(String operationDetail) {
        this.operationDetail = operationDetail;
    }

    public String getRemoteDeviceIp() {
        return remoteDeviceIp;
    }

    public void setRemoteDeviceIp(String remoteDeviceIp) {
        this.remoteDeviceIp = remoteDeviceIp;
    }

    public Users getEqUserUniqueId() {
        return eqUserUniqueId;
    }

    public void setEqUserUniqueId(Users eqUserUniqueId) {
        this.eqUserUniqueId = eqUserUniqueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackingId != null ? trackingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUsageTracking)) {
            return false;
        }
        SysUsageTracking other = (SysUsageTracking) object;
        if ((this.trackingId == null && other.trackingId != null) || (this.trackingId != null && !this.trackingId.equals(other.trackingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SysUsageTracking[ trackingId=" + trackingId + " ]";
    }
    
}
