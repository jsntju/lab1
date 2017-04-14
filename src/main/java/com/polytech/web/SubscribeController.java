package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Justine Denis on 14/04/2017.
 * Controleur de la page d'inscription
 */
@Controller
public class SubscribeController {

    @RequestMapping("/subscribe")
    public String subscribePage() {
        return "subscribe";
    }
}
