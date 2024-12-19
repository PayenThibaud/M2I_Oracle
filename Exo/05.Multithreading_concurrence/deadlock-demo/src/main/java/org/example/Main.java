package org.example;

public class Main {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
    Thread thread1 = new Thread(new Runnable(){
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 verrou 1 acquis");
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 verrou 2 acquis");
                }
            }
        }
    });


    Thread thread2 = new Thread(new Runnable(){
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 verrou 2 acquis");
                try {
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }

            synchronized (lock1) {
                System.out.println("Thread 2 verrou 1 acquis");
            }
        }
    });

    thread1.start();
    thread2.start();
}


}