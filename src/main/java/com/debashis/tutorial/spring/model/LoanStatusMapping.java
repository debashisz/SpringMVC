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
@Table(name = "loan_status_mapping")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "LoanStatusMapping.findAll", query = "SELECT l FROM LoanStatusMapping l")
    , @NamedQuery(name = "LoanStatusMapping.findByLoanStatusMappingId", query = "SELECT l FROM LoanStatusMapping l WHERE l.loanStatusMappingId = :loanStatusMappingId")
    , @NamedQuery(name = "LoanStatusMapping.findByLoanCode", query = "SELECT l FROM LoanStatusMapping l WHERE l.loanCode = :loanCode")
    , @NamedQuery(name = "LoanStatusMapping.findByLoanStatusMasterId", query = "SELECT l FROM LoanStatusMapping l WHERE l.loanStatusMasterId = :loanStatusMasterId")
    , @NamedQuery(name = "LoanStatusMapping.findByCreatedDate", query = "SELECT l FROM LoanStatusMapping l WHERE l.createdDate = :createdDate")
})
public class LoanStatusMapping implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loan_status_mapping_id")
    private Integer loanStatusMappingId;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;
    @Basic(optional = false)
    @Column(name = "loan_status_master_id")
    private int loanStatusMasterId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public LoanStatusMapping()
    {
    }

    public LoanStatusMapping(Integer loanStatusMappingId)
    {
        this.loanStatusMappingId = loanStatusMappingId;
    }

    public LoanStatusMapping(Integer loanStatusMappingId, String loanCode, int loanStatusMasterId, Date createdDate)
    {
        this.loanStatusMappingId = loanStatusMappingId;
        this.loanCode = loanCode;
        this.loanStatusMasterId = loanStatusMasterId;
        this.createdDate = createdDate;
    }

    public Integer getLoanStatusMappingId()
    {
        return loanStatusMappingId;
    }

    public void setLoanStatusMappingId(Integer loanStatusMappingId)
    {
        this.loanStatusMappingId = loanStatusMappingId;
    }

    public String getLoanCode()
    {
        return loanCode;
    }

    public void setLoanCode(String loanCode)
    {
        this.loanCode = loanCode;
    }

    public int getLoanStatusMasterId()
    {
        return loanStatusMasterId;
    }

    public void setLoanStatusMasterId(int loanStatusMasterId)
    {
        this.loanStatusMasterId = loanStatusMasterId;
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
        hash += (loanStatusMappingId != null ? loanStatusMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanStatusMapping))
        {
            return false;
        }
        LoanStatusMapping other = (LoanStatusMapping) object;
        if ((this.loanStatusMappingId == null && other.loanStatusMappingId != null) || (this.loanStatusMappingId != null && !this.loanStatusMappingId.equals(other.loanStatusMappingId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.LoanStatusMapping[ loanStatusMappingId=" + loanStatusMappingId + " ]";
    }
    
}
