package org.example;

public class MonThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + getName() + i + " is running");
            try {
                Thread.sleep(300);
            }catch (InterruptedException e) {
                System.out.println("Thread " + getName() + i + " interrupted");
            }
        }
    }
}
