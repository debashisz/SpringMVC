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
@Table(name = "document_master")
@XmlRootElement
@NamedQueries(
        {
            @NamedQuery(name = "DocumentMaster.findAll", query = "SELECT d FROM DocumentMaster d")
            , @NamedQuery(name = "DocumentMaster.findByDocumentId", query = "SELECT d FROM DocumentMaster d WHERE d.documentId = :documentId")
            , @NamedQuery(name = "DocumentMaster.findByDocumentText", query = "SELECT d FROM DocumentMaster d WHERE d.documentText = :documentText")
        })
public class DocumentMaster implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "document_id")
    private Integer documentId;
    @Basic(optional = false)
    @Column(name = "document_text")
    private String documentText;

    public DocumentMaster()
    {
    }

    public DocumentMaster(Integer documentId)
    {
        this.documentId = documentId;
    }

    public DocumentMaster(Integer documentId, String documentText)
    {
        this.documentId = documentId;
        this.documentText = documentText;
    }

    public Integer getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(Integer documentId)
    {
        this.documentId = documentId;
    }

    public String getDocumentText()
    {
        return documentText;
    }

    public void setDocumentText(String documentText)
    {
        this.documentText = documentText;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (documentId != null ? documentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentMaster))
        {
            return false;
        }
        DocumentMaster other = (DocumentMaster) object;
        if ((this.documentId == null && other.documentId != null) || (this.documentId != null && !this.documentId.equals(other.documentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.debashis.tutorial.spring.model.DocumentMaster[ documentId=" + documentId + " ]";
    }

}
