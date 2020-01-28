package com.barbidule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Creation d'une actualité
 */
@Entity
public class Coordonnee {

    // Précision et génération de l'id de l'actualité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String telephone;
    private String adresse;
    private String horaire;


    // Constructeur vide
    public Coordonnee() {
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }
}