package org.example.exo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)  {
ExecutorServiceExo();
    }

    public static void ExecutorServiceExo() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> System.out.println("Tache " + (finalI + 1 ) + " executer par "+Thread.currentThread().getName()));
        }
        executor.shutdown();
    }
}