package com.abn.concepts.multiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ThreadDemo {
    static int result = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        /*
        System.out.println(ProcessHandle.current().pid());
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread 1 id: " + t1.threadId() + ":" + t1.getName());
        System.out.println("Thread 2 id: " + t2.threadId() + ":" + t2.getName());
        System.out.println("Thread 3 id: " + t3.threadId() + ":" + t3.getName());

        System.out.println("Thread.activeCount(): " + Thread.activeCount());
        System.out.println(Thread.currentThread().getName());

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
            };
        Thread t4 = new Thread(task);
       // t4.run();
        t4.start();

        Runnable task1 = () -> {
            result = 1 + 2;
        };
        Runnable task2 = () -> {
            result = 10 + 10;
            };

            Thread t5 = new Thread(task1);
            t5.start();
            Thread t6 = new Thread(task2);
            t6.start();
            t5.join();
            t6.join();

            System.out.println("Result: " + result);

            Callable<Integer> taskc1 = () -> {
                return 2 + 2;
                };

               FutureTask<Integer> futureTask = new FutureTask<>(taskc1);
               new Thread(futureTask).start();
               System.out.println(futureTask.get());

               Callable<String> taskc2 = () -> {
                   return "AN :" + Thread.currentThread().getName();
                   };

                FutureTask<String> futureTask2 = new FutureTask<>(taskc2);
                new Thread(futureTask2).start();
                System.out.println(futureTask2.get(2, TimeUnit.SECONDS));

                Callable<Integer> task = () -> {
                 Thread.sleep(5000);
                 return 42;
                 };

                    FutureTask<Integer> futureTask3 = new FutureTask<>(task);
                    new Thread(ft).start();

                    if(!ft.isDone()) {
                        System.out.println("Task is still running...");
                    }
                    System.out.println("Result: " + ft.get());

                    Callable<Integer> task = () -> {
                        //Thread.sleep(5000);
                        return 42;
                    };

                    FutureTask<Integer> futureTask3 = new FutureTask<>(task);
                    for(int i = 0; i < 100000; i++) {
                     new Thread(futureTask3).start();
                    }
         */

        Runnable task = () -> {
            System.out.println("Running on : " + Thread.currentThread().getName());
        };

        Thread t4 = new Thread(task);

        System.out.println("-------calling run()-----------");
        t4.run();

        System.out.println(("---------calling start() ------------"));
        t4.start();
    }
}
