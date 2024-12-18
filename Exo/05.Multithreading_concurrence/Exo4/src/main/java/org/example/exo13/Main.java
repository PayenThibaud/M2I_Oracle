package org.example.exo13;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Imprimante imprimante = new Imprimante();

        Thread task1 = new Thread(new Task(imprimante, "Tache-1"));
        Thread task2 = new Thread(new Task(imprimante, "Tache-2"));
        Thread task3 = new Thread(new Task(imprimante, "Tache-3"));

        task1.start();
        task2.start();
        task3.start();

        task1.join();
        task2.join();
        task3.join();

        System.out.println("Toutes les tâches sont terminées.");
    }
}

class Imprimante {
    private final ReentrantLock lock = new ReentrantLock();

    public void useImprimante(String taskName) {
        System.out.println(taskName + " tente d'utiliser l'imprimante...");

        try {
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(taskName + " a acquis le verrou et utilise l'imprimante.");
                    Thread.sleep(2000);
                } finally {
                    lock.unlock();
                    System.out.println(taskName + " a terminé d'utiliser l'imprimante et libère le verrou.");
                }
            } else {
                System.out.println(taskName + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé).");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(taskName + " a été interrompu.");
        }
    }
}

class Task implements Runnable {
    private final Imprimante imprimante;
    private final String taskName;

    public Task(Imprimante imprimante, String taskName) {
        this.imprimante = imprimante;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        imprimante.useImprimante(taskName);
    }
}
