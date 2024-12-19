package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<Integer>());
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        System.out.println("SynchronizedList: ");
        runTest(synchronizedList);

        System.out.println("CopyOnWriteList: " );
        runTest(copyOnWriteList);

        System.out.println("List: ");
        runTest(list);

    }

    private static void runTest(List<Integer> list) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("List size: " + list.size());
    }
}