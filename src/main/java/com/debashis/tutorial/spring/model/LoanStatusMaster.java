/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debashis.tutorial.spring.model;

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
 * @author Windows10
 */
@Entity
@Table(name = "loan_status_master")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "LoanStatusMaster.findAll", query = "SELECT l FROM LoanStatusMaster l")
    , @NamedQuery(name = "LoanStatusMaster.findByLoanStatusMasterId", query = "SELECT l FROM LoanStatusMaster l WHERE l.loanStatusMasterId = :loanStatusMasterId")
    , @NamedQuery(name = "LoanStatusMaster.findByLoanStatusText", query = "SELECT l FROM LoanStatusMaster l WHERE l.loanStatusText = :loanStatusText")
})
public class LoanStatusMaster implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "loan_status_master_id")
    private Integer loanStatusMasterId;
    @Basic(optional = false)
    @Column(name = "loan_status_text")
    private String loanStatusText;

    public LoanStatusMaster()
    {
    }

    public LoanStatusMaster(Integer loanStatusMasterId)
    {
        this.loanStatusMasterId = loanStatusMasterId;
    }

    public LoanStatusMaster(Integer loanStatusMasterId, String loanStatusText)
    {
        this.loanStatusMasterId = loanStatusMasterId;
        this.loanStatusText = loanStatusText;
    }

    public Integer getLoanStatusMasterId()
    {
        return loanStatusMasterId;
    }

    public void setLoanStatusMasterId(Integer loanStatusMasterId)
    {
        this.loanStatusMasterId = loanStatusMasterId;
    }

    public String getLoanStatusText()
    {
        return loanStatusText;
    }

    public void setLoanStatusText(String loanStatusText)
    {
        this.loanStatusText = loanStatusText;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (loanStatusMasterId != null ? loanStatusMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoanStatusMaster))
        {
            return false;
        }
        LoanStatusMaster other = (LoanStatusMaster) object;
        if ((this.loanStatusMasterId == null && other.loanStatusMasterId != null) || (this.loanStatusMasterId != null && !this.loanStatusMasterId.equals(other.loanStatusMasterId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.LoanStatusMaster[ loanStatusMasterId=" + loanStatusMasterId + " ]";
    }
    
}
