package com.abn.design.prodconsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//implement an in-memory key-value store with transaction support in Java, you can use the following approach.
// This implementation will include the basic functionality of the key-value store along with the ability to start,
// commit, and rollback transactions. provide testcase for multi threaded environment

// Mention common issues in multithreaded env.

/*
1. Race condition :Simultaneous read and write operations by multiple threads can lead to inconsistent state if not properly synchronized.
2. Deadlocks: Improper handling of synchronized blocks can lead to deadlocks where two or more threads are waiting indefinitely for each other to release locks.
3. data inconsistency: Without proper synchronization, one thread may see partial updates made by another thread, leading to inconsistent data states.
4. Thread interference: When multiple threads access and modify shared data concurrently, the final outcome may depend on the timing and ordering of the thread execution, leading to unpredictable results.
 */


public class KeyValueStore {
    private Map<String, String> store;
    private ThreadLocal<Stack<Map<String, String>>> transactionStack;

    public KeyValueStore() {
        store = new HashMap<>();
        transactionStack = ThreadLocal.withInitial(Stack::new);
    }

    public synchronized void put(String key, String value) {
        if (transactionStack.get().isEmpty()) {
            store.put(key, value);
        } else {
            transactionStack.get().peek().put(key, value);
        }
    }

    public synchronized String get(String key) {
        if (transactionStack.get().isEmpty()) {
            return store.get(key);
        } else {
            for (int i = transactionStack.get().size() - 1; i >= 0; i--) {
                if (transactionStack.get().get(i).containsKey(key)) {
                    return transactionStack.get().get(i).get(key);
                }
            }
            return store.get(key);
        }
    }

    public synchronized void delete(String key) {
        if (transactionStack.get().isEmpty()) {
            store.remove(key);
        } else {
            transactionStack.get().peek().put(key, null);
        }
    }

    public synchronized void begin() {
        transactionStack.get().push(new HashMap<>());
    }

    public synchronized void commit() {
        if (transactionStack.get().isEmpty()) {
            throw new IllegalStateException("No transaction to commit");
        }
        Map<String, String> changes = transactionStack.get().pop();
        for (Map.Entry<String, String> entry : changes.entrySet()) {
            if (entry.getValue() == null) {
                store.remove(entry.getKey());
            } else {
                store.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public synchronized void rollback() {
        if (transactionStack.get().isEmpty()) {
            throw new IllegalStateException("No transaction to rollback");
        }
        transactionStack.get().pop();
    }
}