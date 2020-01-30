package com.barbidule.controller;

import com.barbidule.entity.Actualite;
import com.barbidule.repository.ActualiteRepository;
import com.barbidule.storage.StorageService;
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
 * Controller permettant d'utiliser CRUD sur les différents objets (intervenants)
 * de la page les présentants.
 */
@Controller
public class ActualiteController {

    private final StorageService storageService;

    @Autowired
    private ActualiteRepository actualiteRepository;

    @Autowired
    public ActualiteController(StorageService storageService) {
        this.storageService = storageService;
    }


    // Controller qui affiche l'actualité à éditer.
    @GetMapping(value = "/admin/actualite")
    public String edit(Model model) {
        // Si l'on trouve l'intervenant
        Optional<Actualite> actualite = actualiteRepository.findById(1);
        if (actualite.isPresent()) {
            // Envoi de l'intervenant à la vue
            model.addAttribute("actualite", actualite.get());
            return "actualite";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'actualité n'existe pas");
    }

    // Controller qui permet la modification de l'actualité.
    @PostMapping("/admin/actualite")
    public String saveEdit(@Valid Actualite actualite, BindingResult bindingResult, Model model) {
        // Si le validateur rencontre des erreurs dans les champs renseignés
        if (bindingResult.hasErrors()) {
            return "actualite";
        }
        // Upload de l'image et définition de son nom en fonction du nom de l'actualité.
        String imageName = "actualite." + actualite.getImage().getContentType().split("/")[1];
        // Sauvegarde de l'image de l'actualité.
        if (actualite.getImage() == null || actualite.getImage().isEmpty()) {
            actualiteRepository.save(actualite);
            return "actualite";
        }
        storageService.store(actualite.getImage(), imageName);
        // Sauvegarde en base de donnée de l'intervenant.
        actualiteRepository.save(actualite);
        return "actualite";


    }


}