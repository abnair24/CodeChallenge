package com.abn.concepts.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalSample {

    static ThreadLocal<String> requestId = new ThreadLocal<>();

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 3; i++) {
            String requestIdValue = "REQ-00" + (i + 1);

                Runnable task = () -> {
                    try {
                        requestId.set(requestIdValue);
                        System.out.println("first call:" + requestId.get());
                    } finally {
                        requestId.remove();
                    }
                };
                service.submit(task);
        }

        for (int i = 0; i < 3; i++) {

            Runnable task = () -> {
                String id = requestId.get();
                System.out.println("second call:" +id);

            };
            service.submit(task);
        }
        service.shutdown();

//        requestId.set("REQ-001");
//        System.out.println("first call:" +requestId.get());
//
//        requestId.set("REQ-002");
//        System.out.println("second call:" + requestId.get());
//
//        System.out.println("third call: "+ requestId.get());
    }
}
