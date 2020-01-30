package com.barbidule.controller;

import com.barbidule.entity.Intervenant;
import com.barbidule.repository.IntervenantRepository;
import com.barbidule.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller permettant d'utiliser CRUD sur les différents objets (intervenants)
 * de la page les présentants.
 */
@Controller
public class IntervenantController {

    private final StorageService storageService;

    @Autowired
    private IntervenantRepository intervenantRepository;

    @Autowired
    public IntervenantController(StorageService storageService) {
        this.storageService = storageService;
    }


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
        // Si l'on trouve l'intervenant
        Optional<Intervenant> intervenant = intervenantRepository.findById(id);
        if (intervenant.isPresent()) {
            // Envoi de l'intervenant à la vue
            model.addAttribute("intervenant", intervenant.get());
            return "intervenant";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'intervenant n'existe pas");
    }

    // Controller qui permet la modification de l'intervenant.
    @PostMapping("/admin/intervenant")
    public String SaveEdit(@Valid Intervenant intervenant, BindingResult bindingResult, Model model) {
        // Si le validateur rencontre des erreurs dans les champs renseignés
        if (bindingResult.hasErrors()) {
            return "intervenant";
        }
        String imageName = intervenant.getName() + "." + intervenant.getImage().getContentType().split("/")[1];
        String imageUrl = "/files/"+imageName;
        // Upload de l'image et définition de son nom en fonction du nom de l'intervenant.
        storageService.store(intervenant.getImage(), imageName);
        intervenant.setImageUrl(imageUrl);
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
    public String SaveIntervenant(@Valid Intervenant intervenant, BindingResult bindingResult, @RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
        String imageName = intervenant.getName() + "." + intervenant.getImage().getContentType().split("/")[1];
        String imageUrl = "/files/"+imageName;
        // Upload de l'image et définition de son nom en fonction du nom de l'intervenant.
        storageService.store(intervenant.getImage(), imageName);
        intervenant.setImageUrl(imageUrl);
        // Sauvegarde en base de donnée de l'intervenant.
        intervenantRepository.save(intervenant);
        return "redirect:/admin/intervenants";
    }


    // Controllers qui permettent la suppression de l'intervenant.
    @GetMapping("/admin/intervenant/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Optional<Intervenant> intervenant = intervenantRepository.findById(id);
        if (intervenant.isPresent()) {
            model.addAttribute("intervenant", intervenant.get());
            return "intervenant_delete";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'intervenant n'existe pas");
    }

    @PostMapping("/admin/intervenant/delete")
    public String deleteIntervenant(Intervenant intervenant) {
        storageService.delete(intervenant.getImageUrl().replace("/files/", ""));
        intervenantRepository.delete(intervenant);
        return "redirect:/admin/intervenants";
    }
}