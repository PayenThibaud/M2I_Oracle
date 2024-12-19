package org.example.exo20;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

            ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

            Runnable ajout = new Runnable() {

                @Override
                public void run() {
                    Thread.currentThread().setName("Ajout");
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
                    Thread.currentThread().setName("Retrait");
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


        long startTime = System.currentTimeMillis();
            ExecutorService executor = Executors.newFixedThreadPool(2);
            executor.execute(ajout);
            executor.execute(retrait);
            executor.shutdown();

            while (!executor.isTerminated()) {
                Thread.sleep(1);
            }
        long endTime = System.currentTimeMillis();
        System.out.println("reel " + (endTime - startTime));

        long startTimeVirtuel = System.currentTimeMillis();
        ExecutorService executorVirtuel = Executors.newVirtualThreadPerTaskExecutor();
        executorVirtuel.execute(ajout);
        executorVirtuel.execute(retrait);
        executorVirtuel.shutdown();

        while (!executorVirtuel.isTerminated()) {
            Thread.sleep(1);
        }
        long endTimeVirtuel = System.currentTimeMillis();
        System.out.println("virtuel " + (endTimeVirtuel - startTimeVirtuel));

            System.out.println("État final de la file : " + queue);


        }
    }


