package com.abn.concepts.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicIntegrr {
    volatile int counter = 0;

    public static void main(String[] args) {

        VolatileAtomicIntegrr volatileAtomicIntegrr = new VolatileAtomicIntegrr();
        try {
            volatileAtomicIntegrr.incrementVolatile();
            volatileAtomicIntegrr.incrementAtomicInteger();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void incrementVolatile() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            service.submit(() -> counter ++);
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(counter);
    }

    public void incrementAtomicInteger() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            service.submit(counter::incrementAndGet);
        }

        service.shutdown();
        service.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(counter.get());
    }
}
