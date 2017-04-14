package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by justine Denis on 17/03/2017.
 * Controleur de la page login (pour se connecter)
 */

/*Mapping pour acceder à page login*/
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }
}
