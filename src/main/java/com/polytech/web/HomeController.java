package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by justine Denis on 16/03/2017.
 * Controlleur de la page Index (page d'ouverture du site)
 */
@Controller
public class HomeController { //home
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String index()
    {
        return "forward:index.html";
    }
}
