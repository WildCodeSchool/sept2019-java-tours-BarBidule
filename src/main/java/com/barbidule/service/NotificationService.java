package com.barbidule.service;

import com.barbidule.entity.Formulaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(Formulaire formulaire) throws MailException {
        // Envoi du mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(formulaire.getEmail());
        mail.setTo("barbidule@mailo.com");
        mail.setSubject("Vous avez reçu un message de "+ formulaire.getName());
        mail.setText("Telephone : " + formulaire.getTel() + "\n\n Message : " + formulaire.getMessage());

        javaMailSender.send(mail);
    }
}
