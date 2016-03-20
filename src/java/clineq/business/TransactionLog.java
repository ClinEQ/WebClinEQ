/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.business;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elijah
 */
@Entity
@Table(name = "TRANSACTION_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionLog.findAll", query = "SELECT t FROM TransactionLog t"),
    @NamedQuery(name = "TransactionLog.findByTransactionId", query = "SELECT t FROM TransactionLog t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "TransactionLog.findByActionName", query = "SELECT t FROM TransactionLog t WHERE t.actionName = :actionName"),
    @NamedQuery(name = "TransactionLog.findByTransactionType", query = "SELECT t FROM TransactionLog t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "TransactionLog.findByTransactionCategory", query = "SELECT t FROM TransactionLog t WHERE t.transactionCategory = :transactionCategory"),
    @NamedQuery(name = "TransactionLog.findByIdentifier", query = "SELECT t FROM TransactionLog t WHERE t.identifier = :identifier"),
    @NamedQuery(name = "TransactionLog.findByContent", query = "SELECT t FROM TransactionLog t WHERE t.content = :content")})
public class TransactionLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name = "ACTION_NAME")
    private String actionName;
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;
    @Column(name = "TRANSACTION_CATEGORY")
    private String transactionCategory;
    @Column(name = "IDENTIFIER")
    private String identifier;
    @Column(name = "CONTENT")
    private String content;

    public TransactionLog() {
    }

    public TransactionLog(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionLog)) {
            return false;
        }
        TransactionLog other = (TransactionLog) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clineq.business.TransactionLog[ transactionId=" + transactionId + " ]";
    }
    
}
