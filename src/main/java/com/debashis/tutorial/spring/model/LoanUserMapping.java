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
@Table(name = "loan_user_mapping")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "LoanUserMapping.findAll", query = "SELECT l FROM LoanUserMapping l")
    , @NamedQuery(name = "LoanUserMapping.findByLoanUserId", query = "SELECT l FROM LoanUserMapping l WHERE l.loanUserId = :loanUserId")
    , @NamedQuery(name = "LoanUserMapping.findByLoanCode", query = "SELECT l FROM LoanUserMapping l WHERE l.loanCode = :loanCode")
    , @NamedQuery(name = "LoanUserMapping.findByUserId", query = "SELECT l FROM LoanUserMapping l WHERE l.userId = :userId")
    , @NamedQuery(name = "LoanUserMapping.findByCreatedDate", query = "SELECT l FROM LoanUserMapping l WHERE l.createdDate = :createdDate")
})
public class LoanUserMapping implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loan_user_id")
    private Integer loanUserId;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public LoanUserMapping()
    {
    }

    public LoanUserMapping(Integer loanUserId)
    {
        this.loanUserId = loanUserId;
    }

    public LoanUserMapping(Integer loanUserId, String loanCode, int userId, Date createdDate)
    {
        this.loanUserId = loanUserId;
        this.loanCode = loanCode;
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public Integer getLoanUserId()
    {
        return loanUserId;
    }

    public void setLoanUserId(Integer loanUserId)
    {
        this.loanUserId = loanUserId;
    }

    public String getLoanCode()
    {
        return loanCode;
    }

    public void setLoanCode(String loanCode)
    {
        this.loanCode = loanCode;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
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
        hash += (loanUserId != null ? loanUserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanUserMapping))
        {
            return false;
        }
        LoanUserMapping other = (LoanUserMapping) object;
        if ((this.loanUserId == null && other.loanUserId != null) || (this.loanUserId != null && !this.loanUserId.equals(other.loanUserId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.LoanUserMapping[ loanUserId=" + loanUserId + " ]";
    }
    
}
