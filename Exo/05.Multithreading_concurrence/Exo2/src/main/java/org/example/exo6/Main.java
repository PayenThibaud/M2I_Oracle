package org.example.exo6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledServiceExo();
    }

    public static void ScheduledServiceExo() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        try {
            scheduler.schedule(() -> System.out.println("Tache 1 executee après 1 seconde, qu une fois."), 1, TimeUnit.SECONDS);
            scheduler.scheduleAtFixedRate(() -> System.out.println("Tache 2 executee toutes les 2 secondes."), 2, 2, TimeUnit.SECONDS);
            scheduler.scheduleWithFixedDelay(() -> System.out.println("Tache 3 executee 3 secondes apres chaque utilisation."), 3, 3, TimeUnit.SECONDS);

            scheduler.schedule(() -> {
                System.out.println("Toutes les taches ont ete executees. Arret du programme.");
                scheduler.shutdown();
            }, 3, TimeUnit.SECONDS);

        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
    }
}

