package com.abn.concepts.multiThreading;

public class Locks {

    public static void main(String[] args)
            throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized(lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized(lock) {
                System.out.println("t2 got the lock");
            }
        });

        t1.start();
        Thread.sleep(100); // let t1 get the lock first
        t2.start();

        Thread.sleep(200);
        System.out.println("T1: State: "+ t1.getState());
        System.out.println("T2: State: " + t2.getState());

        Thread t3 = new Thread(() -> {
            try {
                Thread t4 = new Thread(() -> {
                    try { Thread.sleep(5000); }
                    catch (InterruptedException e) {}
                });
                t4.start();
                t4.join(); // ← t waiting for t2
                System.out.println("t4 state: " + t4.getState());

            } catch (InterruptedException e) {}
        });

        t3.start();
        Thread.sleep(200);
        System.out.println("t3 state: " + t3.getState());
    }
}
