package com.barbidule.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Creation d'une actualité
 */
@Entity
public class Actualite {

    // Précision et génération de l'id de l'actualité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imageUrl;
    @Transient
    private MultipartFile image;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
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