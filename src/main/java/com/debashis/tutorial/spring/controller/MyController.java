package com.debashis.tutorial.spring.controller;

import java.util.Hashtable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController
{

    @Value("${server.port}")
    private String valueFromFile;

    @GetMapping("/")
    public String index(Model model)
    {
        Hashtable<String, String> hs = new Hashtable<String, String>();
        hs.put("key1", "Sony TV");
        hs.put("key2", "Philips TV");
        hs.put("key3", "Onida TV");
        hs.put("key4", "LG TV");
        hs.put("key5", "Samsung TV");

        model.addAttribute("message1", "Hello Spring MVC 5!");
        model.addAttribute("message2", this.valueFromFile);
        model.addAttribute("message3", hs);
        return "index";
    }
}
