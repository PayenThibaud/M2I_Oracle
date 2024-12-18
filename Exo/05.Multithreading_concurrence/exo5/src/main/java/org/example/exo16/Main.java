package org.example.exo16;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        TableauBarrier();
    }

    private static void TableauBarrier() {
        int[] tableau = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] sommeTotal = {0};

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("Somme totale : " + sommeTotal[0]);
        });

        for (int i = 0; i < 4; i++) {
            int indexDebut = i * 2;
            int indexFin = indexDebut + 2;

            new Thread(() -> {
                int totalThread = 0;

                for (int j = indexDebut; j < indexFin; j++) {
                    totalThread += tableau[j];
                }

                System.out.println(Thread.currentThread().getName() + " a calculé une somme partielle de (indice : " + indexDebut + " à indice : " + (indexFin - 1) + ") : " + totalThread);

                synchronized (sommeTotal) {
                    sommeTotal[0] += totalThread;
                }

                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + (i + 1)).start();
        }
    }
}