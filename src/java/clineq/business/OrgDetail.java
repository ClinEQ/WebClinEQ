/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ORG_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgDetail.findAll", query = "SELECT o FROM OrgDetail o"),
    @NamedQuery(name = "OrgDetail.findByEqOrgId", query = "SELECT o FROM OrgDetail o WHERE o.orgDetailPK.eqOrgId = :eqOrgId"),
    @NamedQuery(name = "OrgDetail.findByItemName", query = "SELECT o FROM OrgDetail o WHERE o.orgDetailPK.itemName = :itemName"),
    @NamedQuery(name = "OrgDetail.findByItemValue", query = "SELECT o FROM OrgDetail o WHERE o.itemValue = :itemValue"),
    @NamedQuery(name = "OrgDetail.findByItemDataType", query = "SELECT o FROM OrgDetail o WHERE o.itemDataType = :itemDataType"),
    @NamedQuery(name = "OrgDetail.findByItemStatus", query = "SELECT o FROM OrgDetail o WHERE o.orgDetailPK.itemStatus = :itemStatus"),
    @NamedQuery(name = "OrgDetail.findByLastUpdateDate", query = "SELECT o FROM OrgDetail o WHERE o.lastUpdateDate = :lastUpdateDate")})
public class OrgDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrgDetailPK orgDetailPK;
    @Column(name = "ITEM_VALUE")
    private String itemValue;
    @Column(name = "ITEM_DATA_TYPE")
    private String itemDataType;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @JoinColumn(name = "EQ_ORG_ID", referencedColumnName = "EQ_ORG_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Organizations organizations;

    public OrgDetail() {
    }

    public OrgDetail(OrgDetailPK orgDetailPK) {
        this.orgDetailPK = orgDetailPK;
    }

    public OrgDetail(String eqOrgId, String itemName, String itemStatus) {
        this.orgDetailPK = new OrgDetailPK(eqOrgId, itemName, itemStatus);
    }

    public OrgDetailPK getOrgDetailPK() {
        return orgDetailPK;
    }

    public void setOrgDetailPK(OrgDetailPK orgDetailPK) {
        this.orgDetailPK = orgDetailPK;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemDataType() {
        return itemDataType;
    }

    public void setItemDataType(String itemDataType) {
        this.itemDataType = itemDataType;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Organizations getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations organizations) {
        this.organizations = organizations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgDetailPK != null ? orgDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrgDetail)) {
            return false;
        }
        OrgDetail other = (OrgDetail) object;
        if ((this.orgDetailPK == null && other.orgDetailPK != null) || (this.orgDetailPK != null && !this.orgDetailPK.equals(other.orgDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.OrgDetail[ orgDetailPK=" + orgDetailPK + " ]";
    }
    
}
