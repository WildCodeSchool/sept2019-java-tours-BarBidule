package com.barbidule.barbidule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MainController est une classe ou sont présents les divers controllers
 * permettant de naviguer sur le site.
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

    @GetMapping(value="/admin")
    public String indexAdmin() {
        return "adminPanel";
    }
    
    
}