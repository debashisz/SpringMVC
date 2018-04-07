/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debashis.tutorial.spring.model;

/**
 *
 * @author Windows10
 */
public class Customer
{

    private String custName;
    private String custEmail;
    private String custMobile;
    private String custCard;

    /**
     * @return the custName
     */
    public String getCustName()
    {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName)
    {
        this.custName = custName;
    }

    /**
     * @return the custEmail
     */
    public String getCustEmail()
    {
        return custEmail;
    }

    /**
     * @param custEmail the custEmail to set
     */
    public void setCustEmail(String custEmail)
    {
        this.custEmail = custEmail;
    }

    /**
     * @return the custMobile
     */
    public String getCustMobile()
    {
        return custMobile;
    }

    /**
     * @param custMobile the custMobile to set
     */
    public void setCustMobile(String custMobile)
    {
        this.custMobile = custMobile;
    }

    /**
     * @return the custCard
     */
    public String getCustCard()
    {
        return custCard;
    }

    /**
     * @param custCard the custCard to set
     */
    public void setCustCard(String custCard)
    {
        this.custCard = custCard;
    }

}
