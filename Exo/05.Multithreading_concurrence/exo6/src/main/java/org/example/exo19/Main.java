package org.example.exo19;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        Runnable ajout = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String productName = "Producer-Element-"+ i;
                    queue.offer(productName);
                    System.out.println(Thread.currentThread().getName() + " a ajouté : " + productName);
                }
            }
        };

        Runnable retrait = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (queue.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + " n'a trouvé aucun élément à retirer.");
                    }else {
                        System.out.println(Thread.currentThread().getName() + " a retrait : " + queue.poll());
                    }
                }
            }
        };

        Thread threadAjout = new Thread(ajout);
        Thread threadRetrait = new Thread(retrait);
        threadAjout.start();
        threadRetrait.start();
        threadAjout.join();
        threadRetrait.join();

        System.out.println("État final de la file : " + queue);
    }
}
