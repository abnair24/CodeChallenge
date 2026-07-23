package com.abn.concepts.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChefTask {
    public static void main(String[] args) {

        // case 1:
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Runnable task = () -> {
                System.out.println("Case 1: Task:" + finalI + " running on: " + Thread.currentThread().getName());
            };
            service.submit(task);
        }
        service.shutdown();

        phasedShutdown(service);

        // Case 2: With fixed queue size to simulate rejection of tasks when the queue is full
        ExecutorService serviceWithFixedQueueSize = new ThreadPoolExecutor(
                2,                           // core threads
                2,                           // max threads
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2) // queue capacity = 2
        );

        // Submit 5 tasks
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable task = () -> {
                System.out.println("Case 2: Task:" + finalI + " running on: " + Thread.currentThread().getName());
            };
            try {
                serviceWithFixedQueueSize.submit(task);
            } catch (Exception e) {
                System.out.println("Case 2: Task " + finalI + " rejected: " + task.toString());
            }
        }
        serviceWithFixedQueueSize.shutdown();

        phasedShutdown(serviceWithFixedQueueSize);


        //Case 3: Add fixed queue size with custom rejection handler
        RejectedExecutionHandler handler = (rejectedTask, executor) -> {
            System.out.println("Case 3: Task rejected: " + rejectedTask.toString());
        };

        ExecutorService serviceWithHandler = new ThreadPoolExecutor(
                2,                          // core threads
                2,                          // max threads
                0L, TimeUnit.MILLISECONDS,  // keep alive
                new LinkedBlockingQueue<>(2), // bounded queue
                handler                     // your custom handler
        );

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable task = () -> {
                System.out.println("Case 3: Task:" + finalI + " running on: " + Thread.currentThread().getName());
            };
            serviceWithHandler.submit(task);
        }

        serviceWithHandler.shutdown();

        phasedShutdown(serviceWithHandler);


        //Case 4: Add fixed queue size with caller thread running task
        ExecutorService serviceWithCallerPolicy = new ThreadPoolExecutor(
                2,// core threads
                2,// max threads
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2), // queue capacity = 2
                new ThreadPoolExecutor.CallerRunsPolicy() // caller runs it
        );

        // Submit 5 tasks
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable task = () -> {
                System.out.println("Case 4: Task:" + finalI + " running on: " + Thread.currentThread().getName());
            };
            serviceWithCallerPolicy.submit(task);
        }

        serviceWithCallerPolicy.shutdown();

        phasedShutdown(serviceWithCallerPolicy);
    }

    private static void phasedShutdown(ExecutorService service) {
        try {
            if(!service.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks completed in time.");
                service.shutdownNow();

                // Wait another 60 seconds for them to respond to the interrupt
                if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate! We have zombies.");
                }
            }
        } catch (InterruptedException ie) {
            service.shutdownNow(); // We got interrupted ourselves, pull the plug
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
    }
}
