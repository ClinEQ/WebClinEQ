/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "SYS_CODE_REGISTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysCodeRegistry.findAll", query = "SELECT s FROM SysCodeRegistry s"),
    @NamedQuery(name = "SysCodeRegistry.findByEqOrgId", query = "SELECT s FROM SysCodeRegistry s WHERE s.sysCodeRegistryPK.eqOrgId = :eqOrgId"),
    @NamedQuery(name = "SysCodeRegistry.findByCodeGroupName", query = "SELECT s FROM SysCodeRegistry s WHERE s.sysCodeRegistryPK.codeGroupName = :codeGroupName"),
    @NamedQuery(name = "SysCodeRegistry.findByInGroupSeq", query = "SELECT s FROM SysCodeRegistry s WHERE s.sysCodeRegistryPK.inGroupSeq = :inGroupSeq"),
    @NamedQuery(name = "SysCodeRegistry.findByCodeName", query = "SELECT s FROM SysCodeRegistry s WHERE s.codeName = :codeName"),
    @NamedQuery(name = "SysCodeRegistry.findByCodeValue", query = "SELECT s FROM SysCodeRegistry s WHERE s.codeValue = :codeValue"),
    @NamedQuery(name = "SysCodeRegistry.findByCodeDesc", query = "SELECT s FROM SysCodeRegistry s WHERE s.codeDesc = :codeDesc"),
    @NamedQuery(name = "SysCodeRegistry.findByCodeType", query = "SELECT s FROM SysCodeRegistry s WHERE s.codeType = :codeType"),
    @NamedQuery(name = "SysCodeRegistry.findByStatus", query = "SELECT s FROM SysCodeRegistry s WHERE s.status = :status"),
    @NamedQuery(name = "SysCodeRegistry.findByNotes", query = "SELECT s FROM SysCodeRegistry s WHERE s.notes = :notes")})
public class SysCodeRegistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SysCodeRegistryPK sysCodeRegistryPK;
    @Column(name = "CODE_NAME")
    private String codeName;
    @Column(name = "CODE_VALUE")
    private String codeValue;
    @Column(name = "CODE_DESC")
    private String codeDesc;
    @Column(name = "CODE_TYPE")
    private String codeType;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NOTES")
    private String notes;

    public SysCodeRegistry() {
    }

    public SysCodeRegistry(SysCodeRegistryPK sysCodeRegistryPK) {
        this.sysCodeRegistryPK = sysCodeRegistryPK;
    }

    public SysCodeRegistry(String eqOrgId, String codeGroupName, BigInteger inGroupSeq) {
        this.sysCodeRegistryPK = new SysCodeRegistryPK(eqOrgId, codeGroupName, inGroupSeq);
    }

    public SysCodeRegistryPK getSysCodeRegistryPK() {
        return sysCodeRegistryPK;
    }

    public void setSysCodeRegistryPK(SysCodeRegistryPK sysCodeRegistryPK) {
        this.sysCodeRegistryPK = sysCodeRegistryPK;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysCodeRegistryPK != null ? sysCodeRegistryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysCodeRegistry)) {
            return false;
        }
        SysCodeRegistry other = (SysCodeRegistry) object;
        if ((this.sysCodeRegistryPK == null && other.sysCodeRegistryPK != null) || (this.sysCodeRegistryPK != null && !this.sysCodeRegistryPK.equals(other.sysCodeRegistryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SysCodeRegistry[ sysCodeRegistryPK=" + sysCodeRegistryPK + " ]";
    }
    
}
