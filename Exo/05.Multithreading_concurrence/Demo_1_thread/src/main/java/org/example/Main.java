package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        demoCreationThread();

    }

    public static void demoCreationThread() throws InterruptedException, ExecutionException {


        MonThread monThread = new MonThread();
        monThread.start();



        Thread thread = new Thread(new MonRunnable());
        thread.start();



        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread lambda : " + i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        });
        thread2.start();



        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callableTask = () -> {
          for (int i = 0; i < 10; i++) {
              System.out.println("Callable lambda : " + i);
              Thread.sleep(400);
          }
          return " Callable completed";
        };

        Future<String> futureResult = executor.submit(callableTask);
        System.out.println("Resultat de callable" + futureResult.get());
        executor.shutdown();
    }
}