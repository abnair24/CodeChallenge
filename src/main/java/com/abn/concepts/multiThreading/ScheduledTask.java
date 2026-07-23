package com.abn.concepts.multiThreading;


import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledTask {

    public void scheduleTask()
            throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger count = new AtomicInteger(0);

        ScheduledFuture<?>[] future = new ScheduledFuture<?>[1];
        future[0] = scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Health check: " + LocalDateTime.now());
            int currentCount = count.incrementAndGet();
            if (currentCount >= 5) {
                future[0].cancel(false);
                scheduler.shutdown();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

     public static void main(String[] args)
             throws ExecutionException, InterruptedException {
         ScheduledTask scheduler = new ScheduledTask();

         scheduler.scheduleTask();
     }
}
