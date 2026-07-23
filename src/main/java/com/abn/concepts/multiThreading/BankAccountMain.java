package com.abn.concepts.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccountMain {

    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        BankAccount bankAccount = new BankAccount();
        for (int i = 0; i < 10000; i++) {
             Runnable task = () -> {
                System.out.println("depositing money...");
                bankAccount.deposit();
            };
            service.submit(task);
        }
        service.shutdown();

        service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Final balance:" +bankAccount.getBalance());
    }
}
