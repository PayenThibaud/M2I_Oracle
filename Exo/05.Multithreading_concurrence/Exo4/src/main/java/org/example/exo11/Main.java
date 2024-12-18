package org.example.exo11;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BanAccount bank = new BanAccount(0);
        SynchronizationBankDeposit(bank);
        SynchronizationBankWithdraw(bank);
    }

    private static Thread[] createThreads(Runnable task) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
        }
        return threads;
    }

    private static void runThreads(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }

    private static void SynchronizationBankDeposit(BanAccount bank) throws InterruptedException {
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 3; i++) {
                synchronized (bank) {
                    bank.deposit(10);
                    System.out.println(Thread.currentThread().getName() + " deposit 10");
                }
            }
        });
        runThreads(threads);
        System.out.println("Total : bank depot : " + bank.getSolde());
    }

    private static void SynchronizationBankWithdraw(BanAccount bank) throws InterruptedException {
        Thread[] threads = createThreads(() -> {
            for (int i = 0; i < 4; i++) {
                synchronized (bank) {
                    bank.withdraw(10);
                    System.out.println(Thread.currentThread().getName() + " withdraw 10");
                }
            }
        });
        runThreads(threads);
        System.out.println("Total : bank withdraw : " + bank.getSolde());
    }
}
