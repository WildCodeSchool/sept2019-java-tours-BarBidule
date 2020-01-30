package com.barbidule.controller;

import com.barbidule.entity.Coordonnee;
import com.barbidule.repository.CoordonneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Controller permettant d'editer et d'afficher l'objet (coordonnées de l'association)
 */
@Controller
public class CoordonneeController {
    @Autowired
    private CoordonneeRepository coordonneeRepository;

    // Controller qui affiche les coordonnées à éditer.
    @GetMapping(value = "/admin/coord")
    public String edit(Model model) {
        Optional<Coordonnee> coordonnee = coordonneeRepository.findById(1);
        if (coordonnee.isPresent()) {
            model.addAttribute("coordonnee", coordonnee.get());
            return "coordonnee";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Les coordonnées n'existent pas");
    }

    // Controller qui permet d'enregistrer la modification des coordonnées de l'association.
    @PostMapping("/admin/coord")
    public String SaveEdit(@Valid Coordonnee coordonnee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "coordonnee";
        }
        // Sauvegarde en base de donnée de l'intervenant.
        coordonneeRepository.save(coordonnee);
        return "coordonnee";
    }


}