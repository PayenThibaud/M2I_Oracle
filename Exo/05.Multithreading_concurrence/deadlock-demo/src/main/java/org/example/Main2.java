package org.example;

import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {

        int threadCount = 100_000_000;

        long startTime = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < threadCount; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (OutOfMemoryError | Exception e) {
            System.out.println("Erreur avec les threads natif");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " en ms");
    }
}
