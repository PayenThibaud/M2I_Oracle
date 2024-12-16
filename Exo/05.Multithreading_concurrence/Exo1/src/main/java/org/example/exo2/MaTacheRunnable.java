package org.example.exo2;

public class MaTacheRunnable implements Runnable {

    private final int nombre;


    public MaTacheRunnable(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        int carre = nombre * nombre;
        System.out.println("Le carré de " + nombre + " est : " + carre);
    }
}
