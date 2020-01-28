package com.barbidule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Creation d'un intervenant
 */
@Entity
public class Intervenant {

    // Précision et génération de l'id de l'intervenant
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private String name;
    private String atelier1;
    private String description1;
    private String description2;
    private String description3;
    private String description4;
    private String prix1;
    private String prix2;



    // Constructeur vide
    public Intervenant() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtelier1() {
        return atelier1;
    }

    public void setAtelier1(String atelier1) {
        this.atelier1 = atelier1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getPrix1() {
        return prix1;
    }

    public void setPrix1(String prix1) {
        this.prix1 = prix1;
    }

    public String getPrix2() {
        return prix2;
    }

    public void setPrix2(String prix2) {
        this.prix2 = prix2;
    }
}