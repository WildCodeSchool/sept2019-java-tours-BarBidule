package com.barbidule.barbidule.controller;

import com.barbidule.barbidule.entity.FormuleDuJour;
import com.barbidule.barbidule.repository.FormuleDuJourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller permettant d'utiliser CRUD sur les différents objets (ardoises)
 * de la carte de restauration.
 */
@Controller
public class MenuController {
    @Autowired
    private FormuleDuJourRepository formuleDuJourRepository;

    // Controleur de la page visiteur (normale)
    @GetMapping(value = "/leBarBidule")
    public String barBidule(Model model) {
        List<FormuleDuJour> formulesDuJour = formuleDuJourRepository.findAll();
        if (formulesDuJour.size() > 0) {
            model.addAttribute("formulesDuJour", formulesDuJour);
            return "leBarBidule";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La formule n'existe pas");
    }

    // Controller admin qui affiche la liste des ardoises.
    @GetMapping(value = "/admin/menu")
    public String index(Model model) {
        List<FormuleDuJour> formulesDuJour = formuleDuJourRepository.findAll();
        if (formulesDuJour.size() > 0) {
            model.addAttribute("formulesDuJour", formulesDuJour);
            return "menulist";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La formule n'existe pas");
    }

    // Controller qui affiche l'ardoise à éditer.
    @GetMapping(value = "/admin/menu/{id}")
    public String index(@PathVariable int id, Model model) {
        Optional<FormuleDuJour> formuleDuJour = formuleDuJourRepository.findById(id);
        if (formuleDuJour.isPresent()) {
            model.addAttribute("formuleDuJour", formuleDuJour.get());
            return "menu";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La formule n'existe pas");
    }

    // Controller qui permet la modification et l'enregistrement de l'ardoise.
    @PostMapping("/admin/menu")
    public String editFormule(@Valid FormuleDuJour formuleDuJour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "menu";
        }
        //ferfer
        formuleDuJourRepository.save(formuleDuJour);
        return "menu";
    }

}