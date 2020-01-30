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
    /* Déclaration de la constante pour l'url de l'image afin de pouvoir la conserver
    *  si l'utilisateur decide de ne pas changer l'image à chaque modification de
    *  l'actualité
     */
    final static String IMAGE_URL = "/files/actualite.png";

    // Annotation qui empêche l'enregistrement en base de donnée
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

    // Methode permettant d'acceder à la constante de l'url de l'image dans thymeleaf
    public String getImageUrl() {
        return IMAGE_URL;
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