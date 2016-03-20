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
@Table(name = "ORGANIZATIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizations.findAll", query = "SELECT o FROM Organizations o"),
    @NamedQuery(name = "Organizations.findByEqOrgId", query = "SELECT o FROM Organizations o WHERE o.eqOrgId = :eqOrgId"),
    @NamedQuery(name = "Organizations.findByOrgFullName", query = "SELECT o FROM Organizations o WHERE o.orgFullName = :orgFullName"),
    @NamedQuery(name = "Organizations.findByOrgNameAbbr", query = "SELECT o FROM Organizations o WHERE o.orgNameAbbr = :orgNameAbbr"),
    @NamedQuery(name = "Organizations.findByOrgDisplayName", query = "SELECT o FROM Organizations o WHERE o.orgDisplayName = :orgDisplayName"),
    @NamedQuery(name = "Organizations.findByOrgType", query = "SELECT o FROM Organizations o WHERE o.orgType = :orgType"),
    @NamedQuery(name = "Organizations.findByOrgCategory", query = "SELECT o FROM Organizations o WHERE o.orgCategory = :orgCategory"),
    @NamedQuery(name = "Organizations.findByAddress1", query = "SELECT o FROM Organizations o WHERE o.address1 = :address1"),
    @NamedQuery(name = "Organizations.findByAddress2", query = "SELECT o FROM Organizations o WHERE o.address2 = :address2"),
    @NamedQuery(name = "Organizations.findByCity", query = "SELECT o FROM Organizations o WHERE o.city = :city"),
    @NamedQuery(name = "Organizations.findByState", query = "SELECT o FROM Organizations o WHERE o.state = :state"),
    @NamedQuery(name = "Organizations.findByZip", query = "SELECT o FROM Organizations o WHERE o.zip = :zip"),
    @NamedQuery(name = "Organizations.findByCountry", query = "SELECT o FROM Organizations o WHERE o.country = :country"),
    @NamedQuery(name = "Organizations.findByPhone", query = "SELECT o FROM Organizations o WHERE o.phone = :phone"),
    @NamedQuery(name = "Organizations.findByFax", query = "SELECT o FROM Organizations o WHERE o.fax = :fax"),
    @NamedQuery(name = "Organizations.findByOrgUrl", query = "SELECT o FROM Organizations o WHERE o.orgUrl = :orgUrl"),
    @NamedQuery(name = "Organizations.findByNotes", query = "SELECT o FROM Organizations o WHERE o.notes = :notes"),
    @NamedQuery(name = "Organizations.findByStatus", query = "SELECT o FROM Organizations o WHERE o.status = :status")})
public class Organizations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EQ_ORG_ID")
    private String eqOrgId;
    @Column(name = "ORG_FULL_NAME")
    private String orgFullName;
    @Column(name = "ORG_NAME_ABBR")
    private String orgNameAbbr;
    @Column(name = "ORG_DISPLAY_NAME")
    private String orgDisplayName;
    @Column(name = "ORG_TYPE")
    private String orgType;
    @Column(name = "ORG_CATEGORY")
    private String orgCategory;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "ORG_URL")
    private String orgUrl;
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "eqSiteId")
    private Collection<Subjects> subjectsCollection;
    @OneToMany(mappedBy = "eqSponId")
    private Collection<Studies> studiesCollection;
    @OneToMany(mappedBy = "eqIwrsId")
    private Collection<Studies> studiesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizations")
    private Collection<OrgDetail> orgDetailCollection;
    @OneToMany(mappedBy = "eqOrgId")
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizations")
    private Collection<StudySiteMap> studySiteMapCollection;

    public Organizations() {
    }

    public Organizations(String eqOrgId) {
        this.eqOrgId = eqOrgId;
    }

    public String getEqOrgId() {
        return eqOrgId;
    }

    public void setEqOrgId(String eqOrgId) {
        this.eqOrgId = eqOrgId;
    }

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }

    public String getOrgNameAbbr() {
        return orgNameAbbr;
    }

    public void setOrgNameAbbr(String orgNameAbbr) {
        this.orgNameAbbr = orgNameAbbr;
    }

    public String getOrgDisplayName() {
        return orgDisplayName;
    }

    public void setOrgDisplayName(String orgDisplayName) {
        this.orgDisplayName = orgDisplayName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgCategory() {
        return orgCategory;
    }

    public void setOrgCategory(String orgCategory) {
        this.orgCategory = orgCategory;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Subjects> getSubjectsCollection() {
        return subjectsCollection;
    }

    public void setSubjectsCollection(Collection<Subjects> subjectsCollection) {
        this.subjectsCollection = subjectsCollection;
    }

    @XmlTransient
    public Collection<Studies> getStudiesCollection() {
        return studiesCollection;
    }

    public void setStudiesCollection(Collection<Studies> studiesCollection) {
        this.studiesCollection = studiesCollection;
    }

    @XmlTransient
    public Collection<Studies> getStudiesCollection1() {
        return studiesCollection1;
    }

    public void setStudiesCollection1(Collection<Studies> studiesCollection1) {
        this.studiesCollection1 = studiesCollection1;
    }

    @XmlTransient
    public Collection<OrgDetail> getOrgDetailCollection() {
        return orgDetailCollection;
    }

    public void setOrgDetailCollection(Collection<OrgDetail> orgDetailCollection) {
        this.orgDetailCollection = orgDetailCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<StudySiteMap> getStudySiteMapCollection() {
        return studySiteMapCollection;
    }

    public void setStudySiteMapCollection(Collection<StudySiteMap> studySiteMapCollection) {
        this.studySiteMapCollection = studySiteMapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqOrgId != null ? eqOrgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizations)) {
            return false;
        }
        Organizations other = (Organizations) object;
        if ((this.eqOrgId == null && other.eqOrgId != null) || (this.eqOrgId != null && !this.eqOrgId.equals(other.eqOrgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.Organizations[ eqOrgId=" + eqOrgId + " ]";
    }
    
}
