package com.abn.concepts.multiThreading;

public class Test {

    static int result = 0;

    public static void main(String[] args)
            throws InterruptedException {
        Runnable task = () -> { result = 10 + 10; };
        new Thread(task).start();
        Thread.sleep(1);


        System.out.println(result); // What does this print?
    }
}
