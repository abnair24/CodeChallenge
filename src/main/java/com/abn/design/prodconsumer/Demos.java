package com.abn.design.prodconsumer;

public class Demos {

    public static void main(String[] args) {

        /*
        3 ways of defining threads
         */
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.print("hi");
            }
        });


        ExecuteThread executeThread = new ExecuteThread();
        Thread thread2 = new Thread(executeThread);


        Thread thread3 = new Thread(() -> {
            System.out.print("Hey");
        });


        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ExecuteThread implements Runnable {

    public void run() {
        System.out.println("HI");
    }
}
