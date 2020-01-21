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
    private String name;
    private String atelier1;
    private String description1;
    private String atelier2;
    private String description2;
    private String atelier3;
    private String description3;
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

    public String getAtelier2() {
        return atelier2;
    }

    public void setAtelier2(String atelier2) {
        this.atelier2 = atelier2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getAtelier3() {
        return atelier3;
    }

    public void setAtelier3(String atelier3) {
        this.atelier3 = atelier3;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
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