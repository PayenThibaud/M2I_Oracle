package org.example;

public class ObserverFichier implements IObserver {

    public String name;

    public ObserverFichier(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Ecriture dans le fichier : " + message + " : " + name);
    }
}