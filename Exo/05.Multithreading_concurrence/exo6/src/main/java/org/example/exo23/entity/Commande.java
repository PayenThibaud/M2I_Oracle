package org.example.exo23.entity;

import org.example.exo23.enums.EtatCommande;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private List<Article> articles;

    public Commande(int id, List<Article> articles) {
        this.id = id;
        this.articles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
