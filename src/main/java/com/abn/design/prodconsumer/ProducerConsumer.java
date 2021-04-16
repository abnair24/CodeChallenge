package com.abn.design.prodconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(4);


        Thread producer = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int value =0;
                    while(true) {
                        blockingQueue.put(value);
                        System.out.println("Produced :"+ value++ + ":" + System.currentTimeMillis());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        int value = blockingQueue.take();
                        System.out.println("Consumed :" + value + ":" + System.currentTimeMillis());
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
