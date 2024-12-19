package org.example.exo18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        Runnable addList = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String productName = "Produit "+ (char) ('A'+ ThreadLocalRandom.current().nextInt(3));
                    if (!list.contains(Thread.currentThread().getName() + "-" + productName)) {
                        list.add(Thread.currentThread().getName() + "-" + productName);
                    }
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable Titi = () -> {
            Thread.currentThread().setName("Titi");
            addList.run();
        };

        Runnable Tata = () -> {
            Thread.currentThread().setName("Tata");
            addList.run();
        };

        Runnable Toto = () -> {
            Thread.currentThread().setName("Toto");
            addList.run();
        };

        executor.execute(Titi);
        executor.execute(Tata);
        executor.execute(Toto);
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(1);
        }

        System.out.println(list);
    }}
