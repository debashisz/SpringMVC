/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debashis.tutorial.spring.model;

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
 * @author Windows10
 */
@Entity
@Table(name = "loan_document_status_mapping")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "LoanDocumentStatusMapping.findAll", query = "SELECT l FROM LoanDocumentStatusMapping l")
    , @NamedQuery(name = "LoanDocumentStatusMapping.findByLoanDocumentStatusMappingId", query = "SELECT l FROM LoanDocumentStatusMapping l WHERE l.loanDocumentStatusMappingId = :loanDocumentStatusMappingId")
    , @NamedQuery(name = "LoanDocumentStatusMapping.findByLoanCode", query = "SELECT l FROM LoanDocumentStatusMapping l WHERE l.loanCode = :loanCode")
    , @NamedQuery(name = "LoanDocumentStatusMapping.findByDocumentId", query = "SELECT l FROM LoanDocumentStatusMapping l WHERE l.documentId = :documentId")
    , @NamedQuery(name = "LoanDocumentStatusMapping.findByDocumentStatusMasterId", query = "SELECT l FROM LoanDocumentStatusMapping l WHERE l.documentStatusMasterId = :documentStatusMasterId")
    , @NamedQuery(name = "LoanDocumentStatusMapping.findByCreatedDate", query = "SELECT l FROM LoanDocumentStatusMapping l WHERE l.createdDate = :createdDate")
})
public class LoanDocumentStatusMapping implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loan_document_status_mapping_id")
    private Integer loanDocumentStatusMappingId;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;
    @Basic(optional = false)
    @Column(name = "document_id")
    private int documentId;
    @Basic(optional = false)
    @Column(name = "document_status_master_id")
    private int documentStatusMasterId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public LoanDocumentStatusMapping()
    {
    }

    public LoanDocumentStatusMapping(Integer loanDocumentStatusMappingId)
    {
        this.loanDocumentStatusMappingId = loanDocumentStatusMappingId;
    }

    public LoanDocumentStatusMapping(Integer loanDocumentStatusMappingId, String loanCode, int documentId, int documentStatusMasterId, Date createdDate)
    {
        this.loanDocumentStatusMappingId = loanDocumentStatusMappingId;
        this.loanCode = loanCode;
        this.documentId = documentId;
        this.documentStatusMasterId = documentStatusMasterId;
        this.createdDate = createdDate;
    }

    public Integer getLoanDocumentStatusMappingId()
    {
        return loanDocumentStatusMappingId;
    }

    public void setLoanDocumentStatusMappingId(Integer loanDocumentStatusMappingId)
    {
        this.loanDocumentStatusMappingId = loanDocumentStatusMappingId;
    }

    public String getLoanCode()
    {
        return loanCode;
    }

    public void setLoanCode(String loanCode)
    {
        this.loanCode = loanCode;
    }

    public int getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(int documentId)
    {
        this.documentId = documentId;
    }

    public int getDocumentStatusMasterId()
    {
        return documentStatusMasterId;
    }

    public void setDocumentStatusMasterId(int documentStatusMasterId)
    {
        this.documentStatusMasterId = documentStatusMasterId;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (loanDocumentStatusMappingId != null ? loanDocumentStatusMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanDocumentStatusMapping))
        {
            return false;
        }
        LoanDocumentStatusMapping other = (LoanDocumentStatusMapping) object;
        if ((this.loanDocumentStatusMappingId == null && other.loanDocumentStatusMappingId != null) || (this.loanDocumentStatusMappingId != null && !this.loanDocumentStatusMappingId.equals(other.loanDocumentStatusMappingId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.LoanDocumentStatusMapping[ loanDocumentStatusMappingId=" + loanDocumentStatusMappingId + " ]";
    }
    
}
