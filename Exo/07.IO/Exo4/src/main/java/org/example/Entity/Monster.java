package org.example.Entity;

public class Monster {
    private int nom;
    private int force;
    private int pv;

    public Monster(int nom, int force, int pv) {
        this.nom = nom;
        this.force = force;
        this.pv = pv;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
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
        return "Monster{" +
                "nom=" + nom +
                ", force=" + force +
                ", pv=" + pv +
                '}';
    }
}
