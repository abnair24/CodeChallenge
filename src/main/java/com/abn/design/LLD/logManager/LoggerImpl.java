package com.abn.design.LLD.logManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Level;

public class LoggerImpl implements Logger {

    private static volatile LoggerImpl instance;
    private PrintWriter printWriter;
    private String filePath;
    private static Boolean isClosed = false;

    private LoggerImpl() {

    }

    public static Logger getInstance() {
        if(instance == null) {
            synchronized(LoggerImpl.class) {
                if(instance == null) {
                    instance = new LoggerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        synchronized(LoggerImpl.class) {
            instance = null;
        }
    }

    @Override
    public void log(Level level, String message) {

        if(this.printWriter == null) {
            throw new IllegalStateException("Log file is not set. Please set the log file before logging messages.");
        }
        if(isClosed){
            throw new IllegalStateException("Log file is not set. Please set the log file before logging messages.");
        }
        printWriter.println(LocalDateTime.now() + " [" + level + "] " + message);
    }

    @Override
    public void setLogFile(String filePath) {
        this.filePath = filePath;
        try {
            printWriter = new PrintWriter(new FileWriter(filePath, true));
        } catch (IOException e) {
            throw new RuntimeException("Error initialising log file", e);
        }
    }

    @Override
    public String getLogFile() {
        return this.filePath;
    }

    @Override
    public void flush() {

        if(printWriter == null) {
            throw new IllegalStateException("Log file is not set. Please set the log file before flushing.");
        }
        printWriter.flush();
    }

    @Override
    public void close() {
        if(printWriter == null) {
            throw new IllegalStateException("Log file is not set. Please set the log file before flushing.");
        }
        printWriter.close();
        isClosed = true;
    }
}
