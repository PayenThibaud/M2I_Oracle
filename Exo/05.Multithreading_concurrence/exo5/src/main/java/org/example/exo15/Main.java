package org.example.exo15;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        EtapeSynchroBarrier();
    }

    private static void EtapeSynchroBarrier() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable runnable = () -> {
            for (int etape = 1; etape <= 3; etape++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " atteint l'étape " + etape);
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(runnable, "Thread-" + (i + 1)).start();
        }
    }
}