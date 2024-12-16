package org.example.exo3;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Double>[] futures = new Future[5];
            for (int i = 0; i < 5; i++) {
                futures[i] = executor.submit(new CalculateurCallable(i));
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("Le cube de " + (i + 1) + " est " + futures[i].get());
            }

            executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Thread interompu");
        }
    }
}
