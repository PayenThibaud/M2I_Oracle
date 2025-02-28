package org.example.exo19;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

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
                        Thread.sleep(10);
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

        //    Thread threadAjout = new Thread(ajout);
//            Thread threadRetrait = new Thread(retrait);
//            threadAjout.start();
//            threadRetrait.start();
//            threadAjout.join();
//            threadRetrait.join();


        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(ajout);
        executor.execute(retrait);
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(1);
        }

        System.out.println("État final de la file : " + queue);
    }
}
