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
import javax.persistence.CascadeType;
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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByEqUserId", query = "SELECT u FROM Users u WHERE u.eqUserId = :eqUserId"),
    @NamedQuery(name = "Users.findByLname", query = "SELECT u FROM Users u WHERE u.lname = :lname"),
    @NamedQuery(name = "Users.findByFname", query = "SELECT u FROM Users u WHERE u.fname = :fname"),
    @NamedQuery(name = "Users.findByTitle", query = "SELECT u FROM Users u WHERE u.title = :title"),
    @NamedQuery(name = "Users.findBySetupDate", query = "SELECT u FROM Users u WHERE u.setupDate = :setupDate"),
    @NamedQuery(name = "Users.findByLastUpdateDate", query = "SELECT u FROM Users u WHERE u.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "Users.findByAddress1", query = "SELECT u FROM Users u WHERE u.address1 = :address1"),
    @NamedQuery(name = "Users.findByAddress2", query = "SELECT u FROM Users u WHERE u.address2 = :address2"),
    @NamedQuery(name = "Users.findByZip", query = "SELECT u FROM Users u WHERE u.zip = :zip"),
    @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city"),
    @NamedQuery(name = "Users.findByState", query = "SELECT u FROM Users u WHERE u.state = :state"),
    @NamedQuery(name = "Users.findByCountry", query = "SELECT u FROM Users u WHERE u.country = :country"),
    @NamedQuery(name = "Users.findByStatus", query = "SELECT u FROM Users u WHERE u.status = :status"),
    @NamedQuery(name = "Users.findByExternalEmployerId", query = "SELECT u FROM Users u WHERE u.externalEmployerId = :externalEmployerId"),
    @NamedQuery(name = "Users.findByExternalDeptName", query = "SELECT u FROM Users u WHERE u.externalDeptName = :externalDeptName"),
    @NamedQuery(name = "Users.findByUserType", query = "SELECT u FROM Users u WHERE u.userType = :userType"),
    @NamedQuery(name = "Users.findByUserRole", query = "SELECT u FROM Users u WHERE u.userRole = :userRole"),
    @NamedQuery(name = "Users.findByUserLoginId", query = "SELECT u FROM Users u WHERE u.userLoginId = :userLoginId"),
    @NamedQuery(name = "Users.findByUserLoginPwd", query = "SELECT u FROM Users u WHERE u.userLoginPwd = :userLoginPwd"),
    @NamedQuery(name = "Users.findByFax", query = "SELECT u FROM Users u WHERE u.fax = :fax")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EQ_USER_ID")
    private String eqUserId;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "SETUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date setupDate;
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "EXTERNAL_EMPLOYER_ID")
    private String externalEmployerId;
    @Column(name = "EXTERNAL_DEPT_NAME")
    private String externalDeptName;
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "USER_ROLE")
    private String userRole;
    @Column(name = "USER_LOGIN_ID")
    private String userLoginId;
    @Column(name = "USER_LOGIN_PWD")
    private String userLoginPwd;
    @Column(name = "FAX")
    private String fax;
    @OneToMany(mappedBy = "fromUserId")
    private Collection<Messags> messagsCollection;
    @OneToMany(mappedBy = "sponStudyManagerId")
    private Collection<Studies> studiesCollection;
    @OneToMany(mappedBy = "eqManagerId")
    private Collection<Studies> studiesCollection1;
    @OneToMany(mappedBy = "eqUserUniqueId")
    private Collection<SysUsageTracking> sysUsageTrackingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<StudyUserMap> studyUserMapCollection;
    @JoinColumn(name = "EQ_ORG_ID", referencedColumnName = "EQ_ORG_ID")
    @ManyToOne
    private Organizations eqOrgId;

    public Users() {
    }

    public Users(String eqUserId) {
        this.eqUserId = eqUserId;
    }

    public String getEqUserId() {
        return eqUserId;
    }

    public void setEqUserId(String eqUserId) {
        this.eqUserId = eqUserId;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternalEmployerId() {
        return externalEmployerId;
    }

    public void setExternalEmployerId(String externalEmployerId) {
        this.externalEmployerId = externalEmployerId;
    }

    public String getExternalDeptName() {
        return externalDeptName;
    }

    public void setExternalDeptName(String externalDeptName) {
        this.externalDeptName = externalDeptName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlTransient
    public Collection<Messags> getMessagsCollection() {
        return messagsCollection;
    }

    public void setMessagsCollection(Collection<Messags> messagsCollection) {
        this.messagsCollection = messagsCollection;
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
    public Collection<SysUsageTracking> getSysUsageTrackingCollection() {
        return sysUsageTrackingCollection;
    }

    public void setSysUsageTrackingCollection(Collection<SysUsageTracking> sysUsageTrackingCollection) {
        this.sysUsageTrackingCollection = sysUsageTrackingCollection;
    }

    @XmlTransient
    public Collection<StudyUserMap> getStudyUserMapCollection() {
        return studyUserMapCollection;
    }

    public void setStudyUserMapCollection(Collection<StudyUserMap> studyUserMapCollection) {
        this.studyUserMapCollection = studyUserMapCollection;
    }

    public Organizations getEqOrgId() {
        return eqOrgId;
    }

    public void setEqOrgId(Organizations eqOrgId) {
        this.eqOrgId = eqOrgId;
    }
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eqUserId != null ? eqUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.eqUserId == null && other.eqUserId != null) || (this.eqUserId != null && !this.eqUserId.equals(other.eqUserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.Users[ eqUserId=" + eqUserId + " ]";
    }
    
}
