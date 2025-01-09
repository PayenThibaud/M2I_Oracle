package org.example.Entity;

import java.io.Serializable;

public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private int force;
    private int pv;

    public Character(String nom, int force, int pv) {
        this.nom = nom;
        this.force = force;
        this.pv = pv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    @Override
    public String toString() {
        return "Character{" +
                "nom='" + nom + '\'' +
                ", force=" + force +
                ", pv=" + pv +
                '}';
    }
}
