package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        demoExecutorServiceWithRunnable();
        demoThreadPool();
        demoThreadPool2();
    }

    public static void demoExecutorServiceWithRunnable() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> System.out.println("Task avec un runnable"));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void demoThreadPool() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " executing par " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }

    public static void demoThreadPool2() throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.schedule(() -> System.out.println("Task exe apres 3s"), 3, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Task periodique executee"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(7000);
        scheduler.shutdown();
    }
}