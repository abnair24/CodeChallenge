package com.abn.concepts.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LearnConcurrency {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {

//        Thread t1 = new Thread();
//        t1.start();
//
//        Runnable task = () -> {
//            System.out.println("Thread name: " + Thread.currentThread().getName());
//        };
//        Thread t2 = new Thread(task);
//        t2.start();
//
//        System.out.println("Hello from the main thread! My name is: " + Thread.currentThread().getName());
//
//        ExecutorService service1 = Executors.newSingleThreadExecutor();
//
//        Callable<String> taskc1 = () -> {
//            return "Task Complete!";
//        };
//
//        Future<String> future = service1.submit(taskc1);
//
//
//        System.out.println(future.get(3, TimeUnit.SECONDS));
//
//
//        service1.shutdown();

        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Future<String>> allMyIous = new ArrayList<>();

// --- PHASE 1: SUBMIT ALL TASKS (Workers start immediately) ---
        for (int i = 0; i < 5; i++) {
            Callable<String> heavyTask = () -> {
                Thread.sleep(2000); // Takes 2 seconds
                return "Finished work!";
            };

            // Submit the task and IMMEDIATELY store the IOU in our list
            Future<String> iou = service.submit(heavyTask);
            allMyIous.add(iou);
        }

// --- PHASE 2: MAIN THREAD DOES OTHER WORK ---
        System.out.println("Workers are hammering away. Main thread is doing paperwork...");
// (Imagine some other business logic happening here)


// --- PHASE 3: COLLECT THE RESULTS ---
        for(Future<String> future1 : allMyIous) {
            try {
                System.out.println(future1.get(2, TimeUnit.SECONDS));
            }
            catch (TimeoutException e) {
                System.out.println("A task took too long and timed out! Cancelling remaining tasks...");
                future1.cancel(true);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Main thread was interrupted while waiting for a task to complete.");
                Thread.currentThread().interrupt(); // Restore the interrupted status
            }
        }

        service.shutdown();
    }
}
