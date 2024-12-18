package org.example.exo14;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {

        ChargementBarrier();
    }

    private static void ChargementBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer.");
        });

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ": commence à charger les données.");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ": a terminé le chargement des données.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable, ("Thread-" +i)).start();
        }
    }
}