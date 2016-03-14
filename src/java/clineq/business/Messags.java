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
@Table(name = "MESSAGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messags.findAll", query = "SELECT m FROM Messags m"),
    @NamedQuery(name = "Messags.findByMessageId", query = "SELECT m FROM Messags m WHERE m.messageId = :messageId"),
    @NamedQuery(name = "Messags.findByEqStudyId", query = "SELECT m FROM Messags m WHERE m.eqStudyId = :eqStudyId"),
    @NamedQuery(name = "Messags.findByMessageType", query = "SELECT m FROM Messags m WHERE m.messageType = :messageType"),
    @NamedQuery(name = "Messags.findByToDestination", query = "SELECT m FROM Messags m WHERE m.toDestination = :toDestination"),
    @NamedQuery(name = "Messags.findBySendReceiveDate", query = "SELECT m FROM Messags m WHERE m.sendReceiveDate = :sendReceiveDate"),
    @NamedQuery(name = "Messags.findByWithUploadDoc", query = "SELECT m FROM Messags m WHERE m.withUploadDoc = :withUploadDoc"),
    @NamedQuery(name = "Messags.findByUploadId", query = "SELECT m FROM Messags m WHERE m.uploadId = :uploadId"),
    @NamedQuery(name = "Messags.findByMessage", query = "SELECT m FROM Messags m WHERE m.message = :message")})
public class Messags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MESSAGE_ID")
    private String messageId;
    @Column(name = "EQ_STUDY_ID")
    private String eqStudyId;
    @Column(name = "MESSAGE_TYPE")
    private String messageType;
    @Column(name = "TO_DESTINATION")
    private String toDestination;
    @Column(name = "SEND_RECEIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendReceiveDate;
    @Column(name = "WITH_UPLOAD_DOC")
    private String withUploadDoc;
    @Column(name = "UPLOAD_ID")
    private String uploadId;
    @Column(name = "MESSAGE")
    private String message;
    @JoinColumn(name = "EQ_SUBJECT_ID", referencedColumnName = "EQ_SUBJECT_ID")
    @ManyToOne
    private Subjects eqSubjectId;
    @JoinColumn(name = "FROM_USER_ID", referencedColumnName = "EQ_USER_ID")
    @ManyToOne
    private Users fromUserId;

    public Messags() {
    }

    public Messags(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getEqStudyId() {
        return eqStudyId;
    }

    public void setEqStudyId(String eqStudyId) {
        this.eqStudyId = eqStudyId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getToDestination() {
        return toDestination;
    }

    public void setToDestination(String toDestination) {
        this.toDestination = toDestination;
    }

    public Date getSendReceiveDate() {
        return sendReceiveDate;
    }

    public void setSendReceiveDate(Date sendReceiveDate) {
        this.sendReceiveDate = sendReceiveDate;
    }

    public String getWithUploadDoc() {
        return withUploadDoc;
    }

    public void setWithUploadDoc(String withUploadDoc) {
        this.withUploadDoc = withUploadDoc;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Subjects getEqSubjectId() {
        return eqSubjectId;
    }

    public void setEqSubjectId(Subjects eqSubjectId) {
        this.eqSubjectId = eqSubjectId;
    }

    public Users getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Users fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messags)) {
            return false;
        }
        Messags other = (Messags) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.Messags[ messageId=" + messageId + " ]";
    }
    
}
