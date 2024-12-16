package org.example.exo2;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            MaTacheRunnable maTacheRunnable = new MaTacheRunnable(i);
            Thread thread = new Thread(maTacheRunnable);
            thread.start();
        }
    }
}