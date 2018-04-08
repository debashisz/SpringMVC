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
@Table(name = "loan")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l")
    , @NamedQuery(name = "Loan.findByLoanId", query = "SELECT l FROM Loan l WHERE l.loanId = :loanId")
    , @NamedQuery(name = "Loan.findByLoanCode", query = "SELECT l FROM Loan l WHERE l.loanCode = :loanCode")
    , @NamedQuery(name = "Loan.findByLoanCreatedDate", query = "SELECT l FROM Loan l WHERE l.loanCreatedDate = :loanCreatedDate")
    , @NamedQuery(name = "Loan.findByIsLoanActive", query = "SELECT l FROM Loan l WHERE l.isLoanActive = :isLoanActive")
})
public class Loan implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loan_id")
    private Integer loanId;
    @Basic(optional = false)
    @Column(name = "loan_code")
    private String loanCode;
    @Column(name = "loan_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loanCreatedDate;
    @Basic(optional = false)
    @Column(name = "is_loan_active")
    private boolean isLoanActive;

    public Loan()
    {
    }

    public Loan(Integer loanId)
    {
        this.loanId = loanId;
    }

    public Loan(Integer loanId, String loanCode, boolean isLoanActive)
    {
        this.loanId = loanId;
        this.loanCode = loanCode;
        this.isLoanActive = isLoanActive;
    }

    public Integer getLoanId()
    {
        return loanId;
    }

    public void setLoanId(Integer loanId)
    {
        this.loanId = loanId;
    }

    public String getLoanCode()
    {
        return loanCode;
    }

    public void setLoanCode(String loanCode)
    {
        this.loanCode = loanCode;
    }

    public Date getLoanCreatedDate()
    {
        return loanCreatedDate;
    }

    public void setLoanCreatedDate(Date loanCreatedDate)
    {
        this.loanCreatedDate = loanCreatedDate;
    }

    public boolean getIsLoanActive()
    {
        return isLoanActive;
    }

    public void setIsLoanActive(boolean isLoanActive)
    {
        this.isLoanActive = isLoanActive;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (loanId != null ? loanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loan))
        {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.loanId == null && other.loanId != null) || (this.loanId != null && !this.loanId.equals(other.loanId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.Loan[ loanId=" + loanId + " ]";
    }
    
}
