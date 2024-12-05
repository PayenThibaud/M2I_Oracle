package org.example;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<IObserver> observersConsole = new ArrayList<IObserver>();
    private List<IObserver> observersFichier = new ArrayList<IObserver>();



    public void addObserverConsole(IObserver observer) {
        observersConsole.add(observer);
    }

    public void removeObserverConsole(IObserver observer) {
        observersConsole.remove(observer);
    }

    public void notifyObserversConsole(String message) {
        for (IObserver observer : observersConsole) {
            observer.update(message);
        }
    }




    public void addObserverFichier(IObserver observer) {
        observersFichier.add(observer);
    }

    public void removeObserverFichier(IObserver observer) {
        observersFichier.remove(observer);
    }

    public void notifyObserversFichier(String message) {
        for (IObserver observer : observersFichier) {
            observer.update(message);
        }
    }




    public void soutName(String message) {
        System.out.println("Votre nom :");
        notifyObserversConsole(message);
    }

    public void writeFile() {
        notifyObserversFichier("file.getName");

    }
}
