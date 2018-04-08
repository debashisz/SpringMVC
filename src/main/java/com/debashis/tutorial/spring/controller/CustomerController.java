/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debashis.tutorial.spring.controller;

import com.debashis.tutorial.spring.model.Customer;
import com.debashis.tutorial.spring.util.Helper;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Windows10
 */
@Controller
public class CustomerController
{

    @GetMapping("/customer-insert")
    public String customerForm(Model model)
    {
        model.addAttribute("customer", new Customer());
        String[] multiCheckboxAllValues = new String[7];
        multiCheckboxAllValues[0] = "Mon";
        multiCheckboxAllValues[1] = "Tue";
        multiCheckboxAllValues[2] = "Wed";
        multiCheckboxAllValues[3] = "Thu";
        multiCheckboxAllValues[4] = "Fri";
        multiCheckboxAllValues[5] = "Sat";
        multiCheckboxAllValues[6] = "Sun";
        model.addAttribute("multiCheckboxAllValues", multiCheckboxAllValues);

        return "customer-insert";
    }

    @PostMapping("/customer-insert")
    public String customerSubmit(@ModelAttribute Customer customer, Model model)
    {
        boolean isFormValid = true;
        LinkedList<String> errorMessage = new LinkedList<>();

        if (customer.getCustName().trim().length() <= 0)
        {
            errorMessage.add("Please enter Customer Name.");
        }
        if (customer.getCustEmail().trim().length() <= 0)
        {
            errorMessage.add("Please enter Customer Email.");
        }

        if (customer.getCustEmail().trim().length() > 0)
        {
            if (!Helper.validateEmail(customer.getCustEmail()))
            {
                errorMessage.add("Please enter valid Email.");
            }
        }

        if (customer.getCustMobile().trim().length() <= 0)
        {
            errorMessage.add("Please enter Customer Mobile.");
        }

        if (customer.getCustCard().trim().length() <= 0)
        {
            errorMessage.add("Please enter Credit Card No.");
        }

        if (!errorMessage.isEmpty())
        {
            isFormValid = false;
            model.addAttribute("errorMessages", errorMessage);
        }

        return isFormValid ? "customer-success" : "customer-insert";
    }

}
