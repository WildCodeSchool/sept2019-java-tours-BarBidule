package com.barbidule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Creation d'une actualité
 */
@Entity
public class Actualite {

    // Précision et génération de l'id de l'actualité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String titre;
    private String description;
    private String lien;


    // Constructeur vide
    public Actualite() {
    }


    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}