package com.barbidule.controller;

import com.barbidule.entity.Formulaire;
import com.barbidule.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class FormulaireController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/contact")
    public String signUp(Model model){
        Formulaire formulaire = new Formulaire();
        model.addAttribute("formulaire", formulaire);
        return "contact";
    }

    @PostMapping("/contact")
    public String signUpSuccess(Formulaire formulaire){
        // Envoi du message
        try{
            notificationService.sendNotification(formulaire);
        }catch (MailException e) {
            // catch erreur
        }
        return "contact";
    }
}
