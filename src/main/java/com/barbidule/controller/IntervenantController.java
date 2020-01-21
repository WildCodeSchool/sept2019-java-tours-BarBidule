package com.barbidule.controller;

import com.barbidule.entity.Intervenant;
import com.barbidule.repository.IntervenantRepository;
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
 * Controller permettant d'utiliser CRUD sur les différents objets (intervenants)
 * de la page les présentants.
 */
@Controller
public class IntervenantController {
    @Autowired
    private IntervenantRepository intervenantRepository;

    // Controller admin qui affiche la liste des intervenants.
    @GetMapping(value = "/admin/intervenants")
    public String getAll(Model model) {
        List<Intervenant> intervenants = intervenantRepository.findAll();
        model.addAttribute("intervenants", intervenants);
        return "intervenant_list";
    }

    // Controller qui affiche l'intervenant à éditer.
    @GetMapping(value = "/admin/intervenant/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Intervenant> intervenant = intervenantRepository.findById(id);
        if (intervenant.isPresent()) {
            model.addAttribute("intervenant", intervenant.get());
            return "intervenant";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'intervenant n'existe pas");
    }

    // Controller qui permet la modification de l'intervenant.
    @PostMapping("/admin/intervenant")
    public String SaveEdit(@Valid Intervenant intervenant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "intervenant";
        }
        // Sauvegarde en base de donnée de l'intervenant.
        intervenantRepository.save(intervenant);
        return "intervenant";
    }

    // Controller qui affiche l'intervenant à créer.
    @GetMapping(value = "/admin/intervenant/create")
    public String save(Model model) {
        Intervenant intervenant = new Intervenant();
        model.addAttribute("intervenant", intervenant);
        return "intervenant_form";
    }

    // Controller qui permet l'enrefistrement de l'intervenant.
    @PostMapping("/admin/intervenant/create")
    public String SaveIntervenant(@Valid Intervenant intervenant, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "intervenant_form";
        }
        // Sauvegarde en base de donnée de l'intervenant.
        intervenantRepository.save(intervenant);
        return "redirect:/admin/intervenants";
    }

}