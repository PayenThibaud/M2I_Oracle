package org.example.exo23.entity;

public class Utilisateur {
    private int id;
    private String nom;
    private Panier panier;

   public Utilisateur(int id, String nom) {
       this.id = id;
       this.nom = nom;
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public String toString() {
       return nom;
    }
}
