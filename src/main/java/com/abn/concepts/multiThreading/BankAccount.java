package com.abn.concepts.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance = new AtomicInteger(0);

    public void deposit(){
        balance.incrementAndGet();
    }

    public int getBalance() {
        return balance.get();
    }
}
