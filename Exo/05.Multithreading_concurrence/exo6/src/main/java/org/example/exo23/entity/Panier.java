package org.example.exo23.entity;

import org.example.exo23.enums.EtatCommande;

import java.util.concurrent.ConcurrentHashMap;

public class Panier {
    private int id;
    private ConcurrentHashMap<Article, Integer> articles;
    private EtatCommande etat;
    private Utilisateur utilisateur;

    public Panier(int id, Utilisateur utilisateur, ConcurrentHashMap<Article, Integer> articles) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.articles = articles;
        this.etat = EtatCommande.EN_ATTENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public ConcurrentHashMap<Article, Integer> getArticles() {
        return articles;
    }

    public void setArticles(ConcurrentHashMap<Article, Integer> articles) {
        this.articles = articles;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public String toString() {
        return "Panier{" + "id=" + id + ", utilisateur nom=" + utilisateur.getNom() + ", articles=" + articles + ", etat=" + etat + '}';
    }
}
