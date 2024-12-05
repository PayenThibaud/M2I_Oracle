package org.example;

public class Main {
    public static void main(String[] args) {

        EventManager em = new EventManager();

        IObserver observerConsole = new ObserverConsole("ObsConsole1");
        IObserver observerFichier = new ObserverFichier("ObsFichier1");
        em.addObserverConsole(observerConsole);
        em.addObserverFichier(observerFichier);

        em.soutName("Titi");
        em.writeFile();
    }
}