package org.example.exo23;

import org.example.exo23.entity.Article;
import org.example.exo23.entity.Panier;
import org.example.exo23.entity.Utilisateur;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Article pomme = new Article(1, "Pomme", 10);
        Article banane = new Article(2, "Banane", 5);
        Article poire = new Article(3, "Poire", 2);
        Article fraise = new Article(4, "Fraise", 1);

        Utilisateur titi = new Utilisateur(1, "Titi");
        Utilisateur tata = new Utilisateur(2, "Tata");
        Utilisateur toto = new Utilisateur(3, "Toto");

        ConcurrentHashMap<Article, Integer> concuPanierTiti = new ConcurrentHashMap<>();
        concuPanierTiti.put(pomme, 1);

        Panier panierTiti = new Panier(1, titi, concuPanierTiti );
        titi.setPanier(panierTiti);
        System.out.println(panierTiti.toString());

        Runnable ajoutPanier = new Runnable() {
            @Override
            public void run() {


            }
        };


    }
}
