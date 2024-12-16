package org.example;

public class MonRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() +" "+ i + " is running avec implement");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() +" "+ i + " interrupted avec implement");
            }
        }

    }
}
