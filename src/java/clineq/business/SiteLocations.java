/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "SITE_LOCATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteLocations.findAll", query = "SELECT s FROM SiteLocations s"),
    @NamedQuery(name = "SiteLocations.findByEqLocationId", query = "SELECT s FROM SiteLocations s WHERE s.eqLocationId = :eqLocationId"),
    @NamedQuery(name = "SiteLocations.findByEqSiteId", query = "SELECT s FROM SiteLocations s WHERE s.eqSiteId = :eqSiteId"),
    @NamedQuery(name = "SiteLocations.findBySponSiteId", query = "SELECT s FROM SiteLocations s WHERE s.sponSiteId = :sponSiteId"),
    @NamedQuery(name = "SiteLocations.findByAddress1", query = "SELECT s FROM SiteLocations s WHERE s.address1 = :address1"),
    @NamedQuery(name = "SiteLocations.findByAddress2", query = "SELECT s FROM SiteLocations s WHERE s.address2 = :address2"),
    @NamedQuery(name = "SiteLocations.findByCity", query = "SELECT s FROM SiteLocations s WHERE s.city = :city"),
    @NamedQuery(name = "SiteLocations.findByState", query = "SELECT s FROM SiteLocations s WHERE s.state = :state"),
    @NamedQuery(name = "SiteLocations.findByCountry", query = "SELECT s FROM SiteLocations s WHERE s.country = :country"),
    @NamedQuery(name = "SiteLocations.findByPhone", query = "SELECT s FROM SiteLocations s WHERE s.phone = :phone"),
    @NamedQuery(name = "SiteLocations.findByZip", query = "SELECT s FROM SiteLocations s WHERE s.zip = :zip"),
    @NamedQuery(name = "SiteLocations.findByEmrType", query = "SELECT s FROM SiteLocations s WHERE s.emrType = :emrType"),
    @NamedQuery(name = "SiteLocations.findBySiteLocationName", query = "SELECT s FROM SiteLocations s WHERE s.siteLocationName = :siteLocationName")})
public class SiteLocations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EQ_LOCATION_ID")
    private String eqLocationId;
    @Column(name = "EQ_SITE_ID")
    private String eqSiteId;
    @Column(name = "SPON_SITE_ID")
    private String sponSiteId;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "EMR_TYPE")
    private String emrType;
    @Column(name = "SITE_LOCATION_NAME")
    private String siteLocationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteLocations")
    private Collection<StudyLocationMap> studyLocationMapCollection;

    public SiteLocations() {
    }

    public SiteLocations(String eqLocationId) {
        this.eqLocationId = eqLocationId;
    }

    public String getEqLocationId() {
        return eqLocationId;
    }

    public void setEqLocationId(String eqLocationId) {
        this.eqLocationId = eqLocationId;
    }

    public String getEqSiteId() {
        return eqSiteId;
    }

    public void setEqSiteId(String eqSiteId) {
        this.eqSiteId = eqSiteId;
    }

    public String getSponSiteId() {
        return sponSiteId;
    }

    public void setSponSiteId(String sponSiteId) {
        this.sponSiteId = sponSiteId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmrType() {
        return emrType;
    }

    public void setEmrType(String emrType) {
        this.emrType = emrType;
    }

    public String getSiteLocationName() {
        return siteLocationName;
    }

    public void setSiteLocationName(String siteLocationName) {
        this.siteLocationName = siteLocationName;
    }

    @XmlTransient
    public Collection<StudyLocationMap> getStudyLocationMapCollection() {
        return studyLocationMapCollection;
    }

    public void setStudyLocationMapCollection(Collection<StudyLocationMap> studyLocationMapCollection) {
        this.studyLocationMapCollection = studyLocationMapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqLocationId != null ? eqLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteLocations)) {
            return false;
        }
        SiteLocations other = (SiteLocations) object;
        if ((this.eqLocationId == null && other.eqLocationId != null) || (this.eqLocationId != null && !this.eqLocationId.equals(other.eqLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.SiteLocations[ eqLocationId=" + eqLocationId + " ]";
    }
    
}
