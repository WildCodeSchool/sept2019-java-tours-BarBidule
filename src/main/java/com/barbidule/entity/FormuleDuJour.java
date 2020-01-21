package com.barbidule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Ardoises du resto
 */
@Entity
public class FormuleDuJour {

    // Précision et génération de l'id de l'ardoise
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titreMenu;
    private String titre;
    private String description;
    private String prix;


    // Constructeur vide
    public FormuleDuJour() {
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreMenu() {
        return titreMenu;
    }

    public void setTitreMenu(String titreMenu) {
        this.titreMenu = titreMenu;
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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}