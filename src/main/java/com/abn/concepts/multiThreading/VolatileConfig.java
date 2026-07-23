package com.abn.concepts.multiThreading;

public class VolatileConfig {

    private volatile boolean loaded = false;
    private String dbUrl;
    private int timeout;
    private int maxConnections;

    public void load() {
        dbUrl = "jdbc:mysql://prod:3306/db";
        timeout = 30;
        maxConnections = 100;
        loaded = true; // volatile write
    }

    public String getDbUrl() {
        if (loaded) { // volatile read
            return dbUrl;
        }
        return null;
    }

    public static void main(String[] args) {
        VolatileConfig config = new VolatileConfig();

        Thread loaderThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate loading time
            } catch (InterruptedException e) {}
            config.load();
            System.out.println("Config loaded");
        });

        Thread readerThread = new Thread(() -> {
            while (!config.loaded) { // Wait until config is loaded
                // Busy wait
            }
            System.out.println("DB URL: " + config.getDbUrl());
        });

        loaderThread.start();
        readerThread.start();
    }
}
