package org.example.exo21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ping");
            };

            for (int i = 0; i < 1000; i++) {
                executor.execute(runnable);
            }
        }
    }
}
