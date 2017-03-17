package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ju on 17/03/2017.
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
