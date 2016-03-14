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
@Table(name = "ERROR_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErrorLog.findAll", query = "SELECT e FROM ErrorLog e"),
    @NamedQuery(name = "ErrorLog.findByErrorLogId", query = "SELECT e FROM ErrorLog e WHERE e.errorLogId = :errorLogId"),
    @NamedQuery(name = "ErrorLog.findByErrorType", query = "SELECT e FROM ErrorLog e WHERE e.errorType = :errorType"),
    @NamedQuery(name = "ErrorLog.findByErrorRecordDate", query = "SELECT e FROM ErrorLog e WHERE e.errorRecordDate = :errorRecordDate"),
    @NamedQuery(name = "ErrorLog.findByErrorInModule", query = "SELECT e FROM ErrorLog e WHERE e.errorInModule = :errorInModule"),
    @NamedQuery(name = "ErrorLog.findByErrorSeveratyLevel", query = "SELECT e FROM ErrorLog e WHERE e.errorSeveratyLevel = :errorSeveratyLevel"),
    @NamedQuery(name = "ErrorLog.findByErrorMsg", query = "SELECT e FROM ErrorLog e WHERE e.errorMsg = :errorMsg")})
public class ErrorLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ERROR_LOG_ID")
    private String errorLogId;
    @Column(name = "ERROR_TYPE")
    private String errorType;
    @Column(name = "ERROR_RECORD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date errorRecordDate;
    @Column(name = "ERROR_IN_MODULE")
    private String errorInModule;
    @Column(name = "ERROR_SEVERATY_LEVEL")
    private String errorSeveratyLevel;
    @Column(name = "ERROR_MSG")
    private String errorMsg;

    public ErrorLog() {
    }

    public ErrorLog(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public String getErrorLogId() {
        return errorLogId;
    }

    public void setErrorLogId(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Date getErrorRecordDate() {
        return errorRecordDate;
    }

    public void setErrorRecordDate(Date errorRecordDate) {
        this.errorRecordDate = errorRecordDate;
    }

    public String getErrorInModule() {
        return errorInModule;
    }

    public void setErrorInModule(String errorInModule) {
        this.errorInModule = errorInModule;
    }

    public String getErrorSeveratyLevel() {
        return errorSeveratyLevel;
    }

    public void setErrorSeveratyLevel(String errorSeveratyLevel) {
        this.errorSeveratyLevel = errorSeveratyLevel;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errorLogId != null ? errorLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErrorLog)) {
            return false;
        }
        ErrorLog other = (ErrorLog) object;
        if ((this.errorLogId == null && other.errorLogId != null) || (this.errorLogId != null && !this.errorLogId.equals(other.errorLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.ErrorLog[ errorLogId=" + errorLogId + " ]";
    }
    
}
