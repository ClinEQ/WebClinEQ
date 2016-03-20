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
import javax.persistence.Embeddable;

/**
 *
 * @author Elijah
 */
@Embeddable
public class SysCodeRegistryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_ORG_ID")
    private String eqOrgId;
    @Basic(optional = false)
    @Column(name = "CODE_GROUP_NAME")
    private String codeGroupName;
    @Basic(optional = false)
    @Column(name = "IN_GROUP_SEQ")
    private BigInteger inGroupSeq;

    public SysCodeRegistryPK() {
    }

    public SysCodeRegistryPK(String eqOrgId, String codeGroupName, BigInteger inGroupSeq) {
        this.eqOrgId = eqOrgId;
        this.codeGroupName = codeGroupName;
        this.inGroupSeq = inGroupSeq;
    }

    public String getEqOrgId() {
        return eqOrgId;
    }

    public void setEqOrgId(String eqOrgId) {
        this.eqOrgId = eqOrgId;
    }

    public String getCodeGroupName() {
        return codeGroupName;
    }

    public void setCodeGroupName(String codeGroupName) {
        this.codeGroupName = codeGroupName;
    }

    public BigInteger getInGroupSeq() {
        return inGroupSeq;
    }

    public void setInGroupSeq(BigInteger inGroupSeq) {
        this.inGroupSeq = inGroupSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqOrgId != null ? eqOrgId.hashCode() : 0);
        hash += (codeGroupName != null ? codeGroupName.hashCode() : 0);
        hash += (inGroupSeq != null ? inGroupSeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysCodeRegistryPK)) {
            return false;
        }
        SysCodeRegistryPK other = (SysCodeRegistryPK) object;
        if ((this.eqOrgId == null && other.eqOrgId != null) || (this.eqOrgId != null && !this.eqOrgId.equals(other.eqOrgId))) {
            return false;
        }
        if ((this.codeGroupName == null && other.codeGroupName != null) || (this.codeGroupName != null && !this.codeGroupName.equals(other.codeGroupName))) {
            return false;
        }
        if ((this.inGroupSeq == null && other.inGroupSeq != null) || (this.inGroupSeq != null && !this.inGroupSeq.equals(other.inGroupSeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SysCodeRegistryPK[ eqOrgId=" + eqOrgId + ", codeGroupName=" + codeGroupName + ", inGroupSeq=" + inGroupSeq + " ]";
    }
    
}
