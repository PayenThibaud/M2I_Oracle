package org.example;

import java.util.concurrent.Executors;

public class MainVirtual {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                executor.submit(() -> {
                    System.out.println("Thread virtuel : " + Thread.currentThread());
                });
            }
        }
    }
}
