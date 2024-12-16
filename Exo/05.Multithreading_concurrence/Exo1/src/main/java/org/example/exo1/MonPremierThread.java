package org.example.exo1;

public class MonPremierThread extends Thread{

    private final String threadName;

    public MonPremierThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread-" + threadName + " - Compteur : " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Thread-" + threadName + " - Compteur : " + i + " interrompu.");
            }
        }
    }
}
