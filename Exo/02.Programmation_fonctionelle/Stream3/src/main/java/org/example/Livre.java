package org.example;

import java.time.LocalDate;

public class Livre {
    private String titre;
    private String auteur;
    private String genre;
    private LocalDate datePublication;
    private int nbPages;
    private boolean estDisponible;
    private double prix;

    public Livre(String auteur, String genre, String titre, LocalDate datePublication, int nbPages, boolean estDisponible, double prix) {
        this.auteur = auteur;
        this.genre = genre;
        this.titre = titre;
        this.datePublication = datePublication;
        this.nbPages = nbPages;
        this.estDisponible = estDisponible;
        this.prix = prix;
    }


    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
