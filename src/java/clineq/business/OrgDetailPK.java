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
public class OrgDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EQ_ORG_ID")
    private String eqOrgId;
    @Basic(optional = false)
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "ITEM_STATUS")
    private String itemStatus;

    public OrgDetailPK() {
    }

    public OrgDetailPK(String eqOrgId, String itemName, String itemStatus) {
        this.eqOrgId = eqOrgId;
        this.itemName = itemName;
        this.itemStatus = itemStatus;
    }

    public String getEqOrgId() {
        return eqOrgId;
    }

    public void setEqOrgId(String eqOrgId) {
        this.eqOrgId = eqOrgId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqOrgId != null ? eqOrgId.hashCode() : 0);
        hash += (itemName != null ? itemName.hashCode() : 0);
        hash += (itemStatus != null ? itemStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgDetailPK)) {
            return false;
        }
        OrgDetailPK other = (OrgDetailPK) object;
        if ((this.eqOrgId == null && other.eqOrgId != null) || (this.eqOrgId != null && !this.eqOrgId.equals(other.eqOrgId))) {
            return false;
        }
        if ((this.itemName == null && other.itemName != null) || (this.itemName != null && !this.itemName.equals(other.itemName))) {
            return false;
        }
        if ((this.itemStatus == null && other.itemStatus != null) || (this.itemStatus != null && !this.itemStatus.equals(other.itemStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.OrgDetailPK[ eqOrgId=" + eqOrgId + ", itemName=" + itemName + ", itemStatus=" + itemStatus + " ]";
    }
    
}
