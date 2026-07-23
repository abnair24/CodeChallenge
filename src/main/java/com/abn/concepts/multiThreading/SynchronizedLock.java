package com.abn.concepts.multiThreading;

import java.util.concurrent.CompletableFuture;

public class SynchronizedLock {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        Object lock = new Object();
        Object lock2 = new Object();

// Thread 1
        synchronized(lock) {
            x = 10;
            y = 20;
        }

// Thread 2
        synchronized(lock2) {
            System.out.println(x);
            System.out.println(y);
        }
    }
}
