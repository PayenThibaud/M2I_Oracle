package org.example.exo22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        CompletableFuture<Void> step1 = CompletableFuture.runAsync(() -> {
            System.out.println("Etape 1 : lecture de donnees");
        }, executor);
        CompletableFuture<Void> step2 = step1.thenRunAsync(() -> {
            System.out.println("Etape 2 : Traitement des donnees");
        }, executor);
        CompletableFuture<Void> step3 = step2.thenRunAsync(() -> {
            System.out.println("Etape 3 : Stockage des donnees");
        }, executor);

        step3.join();
    }
}
