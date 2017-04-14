package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ju on 14/04/2017.
 */
@Controller
public class SubscribeController {

    @RequestMapping("/subscribe")
    public String subscribePage() {
        return "subscribe";
    }
}
