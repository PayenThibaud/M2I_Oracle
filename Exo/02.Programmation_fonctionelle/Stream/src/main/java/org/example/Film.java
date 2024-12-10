package org.example;

public class Film {
    private String titre;
    private String date;
    private String auteur;
    private String genre;
    private String nbEntree;

    public Film(String titre, String date, String auteur, String genre, String nbEntree) {
        this.titre = titre;
        this.date = date;
        this.auteur = auteur;
        this.genre = genre;
        this.nbEntree = nbEntree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNbEntree() {
        return nbEntree;
    }

    public void setId(String nbEntree) {
        this.nbEntree = nbEntree;
    }

    @Override
    public String toString() {
        return "Films [titre=" + titre + ", date=" + date + ", auteur=" + auteur + ", genre=" + genre + ", nbEntree=" + nbEntree + "]";
    }
}
