package com.barbidule.controller;

import com.barbidule.entity.FormuleDuJour;
import com.barbidule.entity.Intervenant;
import com.barbidule.repository.FormuleDuJourRepository;
import com.barbidule.repository.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * MainController est une classe ou sont présents les divers controllers
 * permettant de naviguer sur le site.
 */
@Controller
public class MainController {

    // Import, initialisation et configuration automatique des repository.
    @Autowired
    private FormuleDuJourRepository formuleDuJourRepository;
    @Autowired
    private IntervenantRepository intervenantRepository;


    // --------- Mapping général du site -------------

    @GetMapping(value = "/")
    public String index() {
        return "index.html";
    }

    @GetMapping(value = "/documents/prog_A3")
    public String affichageProgramation() {
        return "prog_A3";
    }

    @GetMapping(value = "/admin")
    public String indexAdmin() {
        return "admin_panel";
    }

    // Controleur de la page visiteur (normal) de la page leBarBidule

    @GetMapping(value = "/leBarBidule")
    public String barBidule(Model model) {

        // Envoi de la liste des menus
        List<FormuleDuJour> formulesDuJour = formuleDuJourRepository.findAll();

        // Envoi de la liste des intervenants
        List<Intervenant> intervenants = intervenantRepository.findAll();

        model.addAttribute("intervenants", intervenants);
        model.addAttribute("formulesDuJour", formulesDuJour);
        return "bar_bidule";
    }

    // Controller du deuxième onglet du menu.
    @GetMapping(value = "/cafe")
    public String secondMenu() {
        return "un_cafe_des_enfants";
    }

    // Controller du troisième onglet du menu.
    @GetMapping(value = "/mais")
    public String thirdMenu() {
        return "mais_pas_que";
    }

    // Controller du quatrième onglet du menu.
    @GetMapping(value = "/contact")
    public String MenuContact() {
        return "contact";
    }

}