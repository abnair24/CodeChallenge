package com.abn.design.prodconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KeyValueStoreTest {

    public static void main(String[] args) {
        KeyValueStore kvStore = new KeyValueStore();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable task1 = () -> {
            kvStore.begin();
            kvStore.put("key1", "value1");
            System.out.println("Task 1: " + kvStore.get("key1"));
            kvStore.commit();
        };

        Runnable task2 = () -> {
            kvStore.begin();
            kvStore.put("key2", "value2");
            System.out.println("Task 2: " + kvStore.get("key2"));
            kvStore.commit();
        };

        Runnable task3 = () -> {
            kvStore.begin();
            kvStore.put("key3", "value3");
            System.out.println("Task 3: " + kvStore.get("key3"));
            kvStore.rollback();
            System.out.println("Task 3 after rollback: " + kvStore.get("key3"));
        };

        Runnable task4 = () -> {
            kvStore.begin();
            kvStore.put("key1", "new_value1");
            System.out.println("Task 4: " + kvStore.get("key1"));
            kvStore.commit();
        };

        Runnable task5 = () -> {
            kvStore.begin();
            kvStore.delete("key2");
            System.out.println("Task 5: " + kvStore.get("key2"));
            kvStore.commit();
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        executor.submit(task5);

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final state of the key-value store
        System.out.println("Final key1: " + kvStore.get("key1")); // Expected: new_value1
        System.out.println("Final key2: " + kvStore.get("key2")); // Expected: null
        System.out.println("Final key3: " + kvStore.get("key3")); // Expected: null
    }
}
