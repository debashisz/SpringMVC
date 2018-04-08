/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.debashis.tutorial.spring.controller;

import com.debashis.tutorial.spring.model.Users;
import com.debashis.tutorial.spring.util.HibernateUtilities;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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
public class LoginController
{

    @GetMapping("/login")
    public String getLogin(Model model)
    {
        model.addAttribute("login", new Users());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute Users user, Model model)
    {
        boolean isFormValid = true;
        LinkedList<String> errorMessage = new LinkedList<>();

        if (user.getUserName().trim().length() <= 0)
        {
            errorMessage.add("Please enter User Name.");
            isFormValid = false;
        }
        if (user.getUserPassword().trim().length() <= 0)
        {
            errorMessage.add("Please enter Password.");
            isFormValid = false;
        }

        if (isFormValid)
        {
            try
            {
                boolean isValidLogin = false;

                Session session = HibernateUtilities.getSessionFactory().openSession();
                session.beginTransaction();

                Query qry = session.getNamedQuery("Users.validateLogin");
                qry.setParameter("userName", user.getUserName().trim());
                qry.setParameter("userPassword", user.getUserPassword().trim());
                List lst = qry.list();
                isValidLogin = !lst.isEmpty();
                session.getTransaction().commit();
                HibernateUtilities.shutdown();

                if (isValidLogin)
                {
                    return "redirect:dash_board";
                } else
                {
                    errorMessage.add("Invalid Login Credential.");
                    model.addAttribute("errormessages", errorMessage);
                    model.addAttribute("login", user);
                    return "login";
                }
            } catch (HibernateException ex)
            {
                System.err.print(Arrays.toString(ex.getStackTrace()));
            }
        } else
        {
            model.addAttribute("errormessages", errorMessage);
            model.addAttribute("login", user);
        }

        return "login";
    }

    @GetMapping("/dash_board")
    public String dashBoard(Model model)
    {
        Date dt = new Date();
        model.addAttribute("time", dt.toString());
        return "dash_board";
    }
}
