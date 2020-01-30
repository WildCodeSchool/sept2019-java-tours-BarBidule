package com.barbidule.controller;

import com.barbidule.entity.Actualite;
import com.barbidule.entity.Coordonnee;
import com.barbidule.entity.FormuleDuJour;
import com.barbidule.entity.Intervenant;
import com.barbidule.repository.ActualiteRepository;
import com.barbidule.repository.CoordonneeRepository;
import com.barbidule.repository.FormuleDuJourRepository;
import com.barbidule.repository.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private ActualiteRepository actualiteRepository;
    @Autowired
    private CoordonneeRepository coordonneeRepository;


    // --------- Mapping général du site -------------

    // page accueil
    @GetMapping(value = "/")
    public String index(Model model) {
        // Si l'on trouve une actualité
        Optional<Actualite> actualite = actualiteRepository.findById(1);
        Optional<Coordonnee> coordonnee = coordonneeRepository.findById(1);
        if (coordonnee.isPresent()) {
            model.addAttribute("coordonnee", coordonnee.get());
            if (actualite.isPresent()) {
                // Envoi de l'actualité à la vue
                model.addAttribute("actualite", actualite.get());
                return "index.html";
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'actualité n'existe pas");
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