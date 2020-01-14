package com.barbidule.barbidule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * MainController
 */
@Controller
public class MainController {

    @GetMapping(value="/")
    public String index() {
        return "index.html";
    }

    @GetMapping(value="/documents/prog_A3")
    public String affichageProgramation() {
        return "prog_A3";
    }
    
    
}