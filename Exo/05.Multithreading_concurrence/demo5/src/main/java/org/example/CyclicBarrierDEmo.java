package org.example;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDEmo {

    public static void main(String[] args) {

        //demoSimpleBarrier();

        demoSimpleBarrierAction();
    }

    private static void demoSimpleBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ": Waiting for CyclicBarrier...");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ": continue apres la barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable, ("Thread-" +i)).start();
        }
    }



    private static void demoSimpleBarrierAction() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": tout les thread ont atteint la barriere exec");
            }
        });

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + ": Waiting for CyclicBarrier...");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + ": continue apres la barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable, ("Thread-" +i)).start();
        }
    }
}
