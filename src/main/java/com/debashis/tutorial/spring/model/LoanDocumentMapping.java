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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "loan_document_mapping")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "LoanDocumentMapping.findAll", query = "SELECT l FROM LoanDocumentMapping l")
    , @NamedQuery(name = "LoanDocumentMapping.findByLoanDocumentId", query = "SELECT l FROM LoanDocumentMapping l WHERE l.loanDocumentId = :loanDocumentId")
    , @NamedQuery(name = "LoanDocumentMapping.findByLoanCode", query = "SELECT l FROM LoanDocumentMapping l WHERE l.loanCode = :loanCode")
    , @NamedQuery(name = "LoanDocumentMapping.findByDocumentId", query = "SELECT l FROM LoanDocumentMapping l WHERE l.documentId = :documentId")
    , @NamedQuery(name = "LoanDocumentMapping.findByCreatedDate", query = "SELECT l FROM LoanDocumentMapping l WHERE l.createdDate = :createdDate")
})
public class LoanDocumentMapping implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loan_document_id")
    private Integer loanDocumentId;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;
    @Basic(optional = false)
    @Column(name = "document_id")
    private int documentId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public LoanDocumentMapping()
    {
    }

    public LoanDocumentMapping(Integer loanDocumentId)
    {
        this.loanDocumentId = loanDocumentId;
    }

    public LoanDocumentMapping(Integer loanDocumentId, String loanCode, int documentId, Date createdDate)
    {
        this.loanDocumentId = loanDocumentId;
        this.loanCode = loanCode;
        this.documentId = documentId;
        this.createdDate = createdDate;
    }

    public Integer getLoanDocumentId()
    {
        return loanDocumentId;
    }

    public void setLoanDocumentId(Integer loanDocumentId)
    {
        this.loanDocumentId = loanDocumentId;
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
        hash += (loanDocumentId != null ? loanDocumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanDocumentMapping))
        {
            return false;
        }
        LoanDocumentMapping other = (LoanDocumentMapping) object;
        if ((this.loanDocumentId == null && other.loanDocumentId != null) || (this.loanDocumentId != null && !this.loanDocumentId.equals(other.loanDocumentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.LoanDocumentMapping[ loanDocumentId=" + loanDocumentId + " ]";
    }
    
}
