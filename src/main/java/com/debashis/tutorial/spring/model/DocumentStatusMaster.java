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
@Table(name = "document_status_master")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "DocumentStatusMaster.findAll", query = "SELECT d FROM DocumentStatusMaster d")
    , @NamedQuery(name = "DocumentStatusMaster.findByDocumentStatusMasterId", query = "SELECT d FROM DocumentStatusMaster d WHERE d.documentStatusMasterId = :documentStatusMasterId")
    , @NamedQuery(name = "DocumentStatusMaster.findByDocumentStatus", query = "SELECT d FROM DocumentStatusMaster d WHERE d.documentStatus = :documentStatus")
})
public class DocumentStatusMaster implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "document_status_master_id")
    private Integer documentStatusMasterId;
    @Basic(optional = false)
    @Column(name = "document_status")
    private String documentStatus;

    public DocumentStatusMaster()
    {
    }

    public DocumentStatusMaster(Integer documentStatusMasterId)
    {
        this.documentStatusMasterId = documentStatusMasterId;
    }

    public DocumentStatusMaster(Integer documentStatusMasterId, String documentStatus)
    {
        this.documentStatusMasterId = documentStatusMasterId;
        this.documentStatus = documentStatus;
    }

    public Integer getDocumentStatusMasterId()
    {
        return documentStatusMasterId;
    }

    public void setDocumentStatusMasterId(Integer documentStatusMasterId)
    {
        this.documentStatusMasterId = documentStatusMasterId;
    }

    public String getDocumentStatus()
    {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus)
    {
        this.documentStatus = documentStatus;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (documentStatusMasterId != null ? documentStatusMasterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentStatusMaster))
        {
            return false;
        }
        DocumentStatusMaster other = (DocumentStatusMaster) object;
        if ((this.documentStatusMasterId == null && other.documentStatusMasterId != null) || (this.documentStatusMasterId != null && !this.documentStatusMasterId.equals(other.documentStatusMasterId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.DocumentStatusMaster[ documentStatusMasterId=" + documentStatusMasterId + " ]";
    }
    
}
