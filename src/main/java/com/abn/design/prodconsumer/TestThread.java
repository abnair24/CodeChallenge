package com.abn.design.prodconsumer;

public class TestThread extends Thread {

    String name;
    ThreadDemo threadDemo;

    public TestThread(String name, ThreadDemo threadDemo) {

        this.threadDemo = threadDemo;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        threadDemo.test(name);
    }

    public static class ThreadDemo {
        public synchronized void test(String name) {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "::" + i);

                try {
                    Thread.sleep(500);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo();
        new TestThread("1: ", threadDemo1);
        new TestThread("2: ", threadDemo1);

        new TestThread("3: ", threadDemo1);


    }
}
