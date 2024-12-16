package org.example.aspect2.entity;

import java.time.LocalDate;

public class ObjetCeleste {
    private String nom;
    private String gps;
    private String description;
    private LocalDate date;

    public ObjetCeleste(String nom, String gps, String description, LocalDate date) {
        this.nom = nom;
        this.gps = gps;
        this.description = description;
        this.date = date;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
