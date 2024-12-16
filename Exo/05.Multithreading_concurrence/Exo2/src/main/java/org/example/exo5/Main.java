package org.example.exo5;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorServiceExo();
    }

    public static void ExecutorServiceExo() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer>[] futures = new Future[10];
        try {
            for (int i = 0; i < 10; i++) {
                final int id = i + 1;
                futures[i] = executor.submit(() -> {
                    return id * id;
                });
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Resultat de la tache " + (i + 1) + " : " + futures[i].get());
            }
            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Thread interrupted");
        }
    }
}
