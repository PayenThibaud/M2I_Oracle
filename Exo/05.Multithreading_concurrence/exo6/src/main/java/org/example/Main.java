package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TotalBarrier();
    }

    private static void TotalBarrier() {
        final int[] produitStockA = {0};
        final int[] produitStockB = {0};
        final int[] produitStockC = {0};
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            System.out.println("Produit A :" + produitStockA[0] + ", Produit B :" + produitStockB[0] + ", Produit C : " + produitStockC[0]);
        });

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    ConcurrentHashMap<String, Integer> mapProduit = new ConcurrentHashMap<>();
                    mapProduit.put("ProduitA", 2);
                    mapProduit.put("ProduitB", 10);
                    mapProduit.put("ProduitC", 10);

                    AchatHashMap(mapProduit);
                    ApproHashMap(mapProduit);

                    synchronized (produitStockA) {
                        produitStockA[0] = mapProduit.get("ProduitA");
                    }

                    synchronized (produitStockB) {
                        produitStockB[0] = mapProduit.get("ProduitB");
                    }

                    synchronized (produitStockC) {
                        produitStockC[0] = mapProduit.get("ProduitC");
                    }


                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
            new Thread(runnable).start();
    }

    private static void AchatHashMap(ConcurrentHashMap<String, Integer> map) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    String cle = randomProduct();

                    if (map.get(cle) <= 0) {
                        System.out.println(Thread.currentThread().getName() + " ne peut pas acheter de " + cle + ", " + cle + "quantiter restante : " + map.get(cle));
                    } else {
                        Integer quantiter = map.get(cle);
                        map.put(cle, quantiter - 1);
                        System.out.println(Thread.currentThread().getName() + " a acheté 1 unité de " + cle + ", " + cle + " quantiter restante : " + map.get(cle));
                    }
                }

            }
        };
        Thread thread1 = new Thread(runnable, "Acheteur-1" );
        Thread thread2 = new Thread(runnable, "Acheteur-2" );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static void ApproHashMap(ConcurrentHashMap<String, Integer> map) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    String cle = randomProduct();
                    Integer quantiter = map.get(cle);
                    map.put(cle, quantiter + 10);
                    System.out.println(Thread.currentThread().getName() + " a réapprovisionné 10 unités de " + cle + ", " + cle + " quantiter restante : " + map.get(cle));

                }
            }
        };
        Thread thread = new Thread(runnable, "Réapprovisionneur");
        thread.start();
        thread.join();
    }

    private static String randomProduct() {
        List<String> list = new ArrayList<>();
        list.add("ProduitA");
        list.add("ProduitB");
        list.add("ProduitC");

        Collections.shuffle(list);
        return list.getFirst();
    }
}