package com.barbidule.barbidule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Controller permettant d'utiliser CRUD sur les différents objets (ardoises)
 * de la carte de restauration.
 */
@Controller
public class MenuController {

    @GetMapping(value = "/leBarBidule")
    public String index() {
        return "bar_bidule.html";
    }

    @GetMapping(value = "/leBarBidule/admin")
    public String indexAdmin() {
        return "bar_bidule.html";
    }

}